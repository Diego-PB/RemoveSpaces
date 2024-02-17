# RemoveSpaces
<em>Diego Penicaud-Bernal</em>
> Objective: Remove useless spaces of an CSS code.

> Warning:
> - Be sure to have a recent version of [java on your computer](https://www.oracle.com/fr/java/technologies/downloads/#jdk21-windows)
> - Use only Hexadecimal colors.
> - if you code a hexcolor before a number (exemple: `#fff 20px`), the program will not work.
> - care about the spaces between number without unit (exemple: border-radius:0 0 15px 15px;), the spaces will be deleted.

### Note:
Please be aware that the code and variable/function names are commented in **French**.

It will be translated in English in the future.

## V1.1 - RemoveSpaces

[v1.1 - file](src/V1_1_RemoveSpaces.java)

This version will delete EVERY space.

## V1.2 - RemoveSpaces

[v1.2 - file](src/V1_2_RemoveSpaces.java) - Last version of the project

This version will delete only the spaces that are not necessary.

List of the different spaces that will be not deleted:

- After a `div`
    - exemple: `<div class>`


- After a `solid`
    - exemple: `border:solid 20px`
    - exemple: `border:solid #fff`


- After a unit
  - exemple: `border-radius:2px 2px`


- Before a `#`
    - exemple: `border:solid 20px #fff`

- Before a `solid` if there is a unit before
    - exemple: `border:20px solid #fff`

- Before a `solid` if there is a hexColor before
    - exemple: `border:#fff solid`


## V1.3 - RemoveSpaces - current version

[V1.3_RemoveSpaces](src/V1_3_RemoveSpaces.java)

This version is the same as the V2, but remove useless characters.

List of the different characters that will be deleted:

- `;` after a `}`
-  the last `}`
- `</style>`
- the last `</div>`

