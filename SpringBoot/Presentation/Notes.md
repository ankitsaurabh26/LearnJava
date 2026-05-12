#### 1. Manual Servlet Configuration (web.xml)

**The Problem**: You had to manually write a massive XML file called `web.xml`. If you wanted `/students` to go to a specific piece of code, you had to type out the XML.

##### Servlets
- Handle http requests
- not executed by JVM
- helps in generating dynamic responses
- present in server computers

#### 2. Need External Server (Tomcat Setup)

**The Problem**: Download and install a separate piece of software (`Apache Tomcat` or `Jetty`) on your computer or server. You then had to package your code into a `.war file` and "`deploy`" it into that server.

##### .jar vs .war
- `.jar` - When building a modern, "standalone" application.
- `.war` - When deploying the app to a separate, pre-installed server.

#### 3. Boilerplate-Heavy

**The Problem**: To do something simple, like `connecting to a database`,one has to write lines of code just to open the connection, handle errors, and close the connection. Spend `80% time writing setup code`.

#### 4. Tight Coupling, Hard to Scale

**Tight Coupling**: Everything used to be stuck together. If one changed the database, s/he often had to `change different files` because they were all "tightly" connected.

```
interface Engine {
    void start();
}
```

```
class PetrolEngine implements Engine {
    public void start() {
        System.out.println("Petrol engine started");
    }
}

class ElectricEngine implements Engine {
    public void start() {
        System.out.println("Electric engine started");
    }
}
```

#### Tight Coupling
```
class Car {
    private Engine engine;

    public Car() {
        // Hardcoded dependency
        engine = new PetrolEngine();
    }

    void drive() {
        engine.start();
        System.out.println("Car is moving");
    }
}
```

#### Loose Coupling
```
class Car {
    private Engine engine;

    // Dependency is passed from outside
    public Car(Engine engine) {
        this.engine = engine;
    }

    void drive() {
        engine.start();
        System.out.println("Car is moving");
    }
}
```

**Hard to Scale**: Without spring boot, apps were giant "Monoliths" (one big heavy block), one cannot easily split them up. Load handling wasn't easy as well.

---

#### Spring Boot:

- `Annotations`: Replacing web.xml with simple tags like `@RestController`.

- `Embedded Server`: The `server inside your app`. Just run "main", and the server starts automatically. `mvn spring-boot:run`

> `maven : Build & Deployment tool. Downloads Dependencies`

- `Starters`: Giving you "Starter" packages that handle all the boilerplate for you. `start.spring.io`

---

#### IoC

**Without IoC**:
```
Engine e = new Engine()
```

**With IoC**:
```
Engine e = Spring.getBean(Engine.class)
```

---

#### Constructor Injection why recommended?
- Can mark your dependencies as `final`

> In Java, a final variable must be given a value at the moment it is created (either on the same line or inside the constructor).

- `final` means: "This must be decided at birth."

- Field Injection (`@Autowired` on the variable) means: "Decide this shortly after birth."

- **No "Partial" Objects**: With Field or Setter injection, you can accidentally create an object that is missing a piece (like a car without a steering wheel). With a Constructor, the object cannot even exist unless all its dependencies are provided.

- Spring-Free Testing

--- 

#### @SpringBootApplication

- `SpringBootConfiguration` : tells Spring that this class is a "Map" or "Blueprint" for your application
- `@ComponentScan` : **looks for classes labeled with** @Service, @Repository, or @Controller. When it finds one, it **automatically creates a Bean**.
- `@EnableAutoConfiguration` : **makes guesses** about **what you need based on the files** (JARs) you have in your project - automation part

> `Spring + @EnableAutoConfiguration =  Spring Boot`

--- 

#### DTO

- Hides **Sensitive Data** (password, internalID etc.)
- **Reducing "Chatter"**: Instead of making 5 calls to get 5 different pieces of info, you can bundle everything into one DTO "package" and send it in one go.
- **Decoupling**: If you change your Database table structure, you don't have to break your Frontend. You just update the mapping to the DTO.

---

#### JSON & HTML

In Spring Boot, the Controller decides the format of the response.

##### 1. Returning JSON (The Modern Way)

Use the `@RestController` annotation. Spring Boot automatically converts your **Java objects into JSON format** using a library called `Jackson`.

```
@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/user")
    public UserDTO getUser() {
        // Spring automatically turns this Java Object into JSON!
        return new UserDTO("Gem", "gem@example.com");
    }
}
```

##### 2. Returning HTML (The Website Way)

Use the `@Controller` annotation and a "Template Engine" like `Thymeleaf`. Instead of returning data, the method returns the name of the HTML file

```
@Controller
public class WebController {

    @GetMapping("/welcome")
    public String welcomePage(Model model) {
        // Adding data to the "Model" so the HTML can see it
        model.addAttribute("name", "Gem");
        
        // Returns the name of the file: "welcome.html"
        return "welcome"; 
    }
}
```