# RemoveSpaces

> Objective: Remove useless spaces of an CSS code.

> Warning: 
> - Use only Hexadecimal colors.
> - if you code a hexcolor before a number (exemple: `#fff 20px`), the program will not work.

### Note:
Please be aware that the code and variable/function names are commented in **French**.

It will be translated in English in the future.

## V1 - RemoveSpaces

[v1 - file](V1_RemoveSpaces/V1_RemoveSpaces.java)

This version will delete EVERY space.

## V2 - RemoveSpaces - in progress

[v2 - file](V2_RemoveSpaces/V2_RemoveSpaces.java)

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






## V3 - RemoveSpaces - in progress

[V3_RemoveSpaces](V3_RemoveSpaces/V3_RemoveSpaces.java)

This version is the same as the V2, but remove useless characters.

List of the different characters that will be deleted:

- `;` after a `}`
- `</style>`
- the last `</div>`


## V4 - RemoveSpaces

This version is the same as the V3, but with a new interface.