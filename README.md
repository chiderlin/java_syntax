### Compile

javac `<file name>`

`javac Main.java`

java `<file name>`

`java Main`

entry point main
`public static void main(String[] args`

### Encapsulation(Main.java)

1. Data Hiding

- Use access modifiers (e.g., `private`) to restrict direct access to class attributes.
- External code cannot directly access or modify the attributes, which helps prevent accidetal or improper changes.

2. Controlled Access and Modification

- Provide `getter` and `setter` methods to allow controlled access to attributes, with optional logic to validate the data.
- If necessary, you can omit `setter` methods to make certain attributes read-only.

3. Hiding Implementation Details

- The internal workings of the class are hidden from the outside world, exposing only a simplified interface(methods) for interaction.
- This makes the class easier to use and reduces the risk of unintended interference.

4. Simplified Methods for External Use

- Beyond `getter` and `setter` methods, you can encapsulate complex behaviour in methods to hide the complexity and provide a straightforward interface.

### Packages(/mypack)

Use `package` keyword

```Note
└── root
  └── mypack
    └── MyPackageClass.java
```

- Compile MyPackageClass.java: javac mypack/MyPackageClass.java
- Run MyPackageClass: java mypack.MyPackageClass

### Constructors

=> same as `def __init__()` in python

### Inheritance(Car.java)

- subclass(child): the class that inherits from another class.
- superclass(parent): the class being inerited from.

### Polymorphism(AnimalMain.java)

Use those methods to perform different tasks. This allows us to perform a single action in different ways.

### Inner Classes(InnerClassMain.java)

A class within a class. The purpose of nested classes is to group classes that belong together, which making code more readable and maintanable.

### Abstract Classes

The `abstract` keyword is a non-access modifier, used for classed and methods:

- Abstract class: is a restricted class that cannot be used to create objects
  (to access it, it must be inherited from another class).
- Abstract method: can only be used in an abstract class, and it does not have a body.
  The body is provided by the subclass(inherited from).

### Interface(InterfaceMain.java)

An `interface` is a completely "abstract class" that is used to group related methods with empty bodies.

To access the interface methods, the interface must be "implemented" by another class with the `implements` keywords (instead of extends).

### `String[]` vs `ArrayList` vs `List<String>` vs `LinkedList`

`String[]`: Fixed size. (Part of Java core syntax.)

```Java
String[] array = new String[3]; //fixed
array[0] = "Apple";
array[1] = "Banana";
array[2] = "Cherry";
// couldn't add new element.

// anthter way
String[] array = {"Apple", "Banana", "Cherry"};
```

---

**Advance type of Array.**

`List<String>`: (Part of `java.uti` package.) An **interface**.

An interface, couldn't use it directly. must use `ArrayList` or `LinkedList` to implement the class.

```
List (interface)
├── ArrayList (Implementation class)
└── LinkedList (Implementation class)

```

```Java
List<String> list = new List<>(); // error!

// correct way to use
List<String> list = new ArrayList<>();
list.add("Apple");
list.add("banana");
list.add("Cherry");
Collections.sort(list); // sorting
System.out.println(list.get(0)); // access via index

List<String> list2 = LinkedList<>();


// flexibility to switch
List<String> list = new ArrayList<>(); // Using ArrayList
list = new LinkedList<>(); // Switch to LinkedList

```

`ArrayList`: Resizable array, which can be found in the `java.util` package. (Part of `java.uti` package.)

`LinkedList`: The `Linkedlist` class has all of the same methods as the `ArrayList` class b/c **they both implement the `List` interface.** However, while the `ArrayList` class and `LinkedList` class can be used in the same way, they are built very differently. (Part of `java.uti` package.)

```
addFist()
addLast()
removeFirst()
removeLast()
getFirst()
getLast()
```

Use an `ArrayList` for storing and accessing data, and `LinkedList` to manipulate data.

### HashMap(HashMapMain.java)

store key/value pairs

- put()
- get() -> return value
- remove()
- clear()

### Threads(ThreadMain.java)

Allows a program to operate more efficiently by doing multiple things at the same time.
Threads can be used to perform complicated tasks in the background w/o interrupting the main program.

### Lambda

_parameter_ -> _expression_

To use more than one parameter
(_parameter1_, _parameter2_) -> _expression_
(_parameter1_, _parameter2_) -> { code block }

### Files(FileMain.java)
