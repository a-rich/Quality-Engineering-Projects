def some_unit(x, y):
    a = 0

    if x and y:
        a = (x*y)**(x-y)
    elif x and not y:
        a = (x*(y+1))**(x-y)
    elif not x and y:
        a = ((x+1)*y)**(x-y)
    else:
        a = ((x+1)*(y+1))**(x-y)

    if a > 0:
        return 'Positive'
    else:
        return 'Non-positive'
