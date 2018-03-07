def some_unit(x, y):
    a = 0

    if x:                             # P1
        if y:                         # P2
            a = (x*y)**(x-y)
        else:
            a = (x*(y+1))**(x-y)
    else:
        if y:
            a = ((x+1)*y)**(x-y)
        else:
            a = ((x+1)*(y+1))**(x-y)

    return a
