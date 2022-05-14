import turtle
t=turtle.Turtle()
s=turtle.Screen()
s.bgcolor("black")
t.setpos(300,0)
t.pencolor("red")
t.speed(100)
b=200
while b>0:
    t.left(b)
    t.forward(b*3.25)
    b=b-0.5
    
