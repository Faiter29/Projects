import turtle
import math
to=turtle.Turtle()
to.speed(100)

def pos(t, x, y):
    t.pu()
    t.goto(x,y)
    t.pd()
    
def kvet(t, lupen, uhollupena, velkostlupena):
    for i in range(lupen):
        zakrivenie=2*math.pi*velkostlupena*uhollupena/360
        n=int(zakrivenie/3)+1
        ciara=zakrivenie/n
        uhol=uhollupena/n
        for i in range(2):
            for i in range(n):
                t.fd(ciara)
                t.lt(uhol)
            t.lt(180-uhollupena)
        t.lt(360/lupen)

def stonka(t, uholstonky, velkoststonky):
    t.setheading(270)
    t.rt(uholstonky/2)
    zakrivenie=2*math.pi*velkoststonky*uholstonky/360
    n=int(zakrivenie/3)+1
    uhol=uholstonky/n
    ciara=zakrivenie/n
    for i in range(n):
        t.fd(ciara)
        t.lt(uhol)

def lis(t, uhollistu, velkostlistu, uholodzeme):
    zakrivenie=2*math.pi*velkostlistu*uhollistu/360
    n=int(zakrivenie/3)+1
    uhol=uhollistu/n
    ciara=zakrivenie/n
    for i in range(2):
        if (i%2==0):
            t.seth(0+uholodzeme)
        else:
            t.seth(180-uholodzeme-uhollistu)
        for i in range(2):
            for i in range(n):
                t.fd(ciara)
                t.lt(uhol)
            t.lt(180-uhollistu)
        
 
pos(to, -200, 50)
kvet(to, 7, 60, 75,)
stonka(to, 70, 170)
lis(to, 60, 100, 30)

pos(to, 0, 50)
kvet(to, 10, 90, 50)
stonka(to, 40, 350)
lis(to, 20, 350, 60)

pos(to, 200, 50)
kvet(to, 20, 30, 100)
stonka(to, 35, 330)
lis(to, 100, 80, 0)

to.hideturtle()
turtle.mainloop()
