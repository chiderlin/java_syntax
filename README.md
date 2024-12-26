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

### Inheritance(Car.java)

- subclass(child): the class that inherits from another class.
- superclass(parent): the class being inerited from.

### Polymorphism(AnimalMain.java)

use those methods to perform different tasks. This allows us to perform a single action in different ways.

### Inner Classes

### Abstract Classes

### Interface

### `String[]` vs `ArrayList` vs `List<String>` vs `LinkedList`

### HashMap(HashMapMain.java)

store key/value pairs

- put()
- get() -> return value
- remove()
- clear()

### Threads

### Lambda

### Files
