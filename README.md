Projeto API Rest - Avanade

*Diagrama de classes

´´´mermaid

classDiagram
    class Owner {
        +String name
    }

    class Car {
        +String brand
        +String model
        +int year
    }

    class News {
        +String icon
        +String description
    }

    Owner "1" -- "1" Car : possui
    Owner "1" -- "many" News : recebe atualizações

![car_registry_diagram](https://github.com/user-attachments/assets/dcd66035-e63a-4656-8fcd-a64b482eadca)

