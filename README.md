# RemoveSpaces

> Objective: Remove useless spaces of an CSS code.

### Note:
Please be aware that the code and variable/function names are commented in **French**.

It will be translated in English in the future.

## V1 - RemoveSpaces - (Need translation to English)

This version will delete EVERY space.

[v1 - file](V1_RemoveSpaces/RemoveSpaces.java)


## V2 - RemoveSpaces - (Need translation to English)

This version will delete only the spaces that are not necessary.

List of the different spaces that will be not deleted:

- After a `div`
    - exemple: `<div class>`


- After a `solid`
    - exemple: `border:solid 20px #fff`


- Before a `#`
    - exemple: `border:solid 20px #fff`


## V3 - RemoveSpaces

This version is the same as the V2, but remove useless characters.

List of the different characters that will be deleted:

- `;` after a `}`
- `</style>`
- the last `</div>`


## V5 - RemoveSpaces

This version is the same as the V3, but with a new interface.