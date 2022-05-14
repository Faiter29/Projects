import turtle

##turtle.speed(100)
def f(n):
    for j in range(0,2):
        turtle.left(36)
        for i in range(0,5):
            turtle.forward(n)
            turtle.left(72)
            turtle.forward(n)
            turtle.left(108)
            turtle.forward(n)
            turtle.left(72)
            turtle.forward(n)
            turtle.right(180)
def g(n):
    turtle.forward(n)
    turtle.left(72)
    turtle.forward(n)
    turtle.left(72)
    for k in range(0,10):
        turtle.forward(100)
        turtle.left(36)
##def f(n):
##    for i in range(0,10):
##        turtle.left(36)
##        for i in range(0,5):
##            turtle.forward(n)
##            turtle.left(72)
    
f(100)
g(100)
