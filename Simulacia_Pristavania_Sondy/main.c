#include <stdio.h>

int stavmotora(double v,double Vsoft){
    if (v<Vsoft) return 1;
    else return 0;
}
double vyska(double H,double v0,double dt,double a){
    H=H+v0*dt+(a*dt*dt)/2;
    return H;
}

double rychlost(double v0,double a,double dt){
    v0=v0+a*dt;
    return v0;
}

int main() {
    double m,T,v0,H,g,Vsoft,dt,t=0;
    int s=0;double a,total=0;
    printf("Zadaj:\n");
    printf("hmotnost sondy\n");
    scanf("%lf",&m);
    printf("tah motora\n");
    scanf("%lf",&T);
    printf("pociatocnu rychlost sondy\n");
    scanf("%lf",&v0);
    printf("pociatocnu vysku sondy nad povrchom vesmirneho objektu/planety\n");
    scanf("%lf",&H);
    printf("gravitacne zrychlenie vesmirneho objektu/planety\n");
    scanf("%lf",&g);
    printf("max. povolena rychlost sondyv okamihu pristavania potrebna na bezpecne pristatie(m/s)\n");
    scanf("%lf",&Vsoft);
    printf("casovy krok simulacie\n");
    scanf("%lf",&dt);
    //scanf("%lf %lf %lf %lf %lf %lf %lf",&m,&T,&v0,&H,&g,&Vsoft,&dt);
    printf("m=%.3lf\nT=%.3lf\nv0=%.3lf\nH=%.3lf\ng=%.3lf\nvsoft=%.3lf\ndt=%.3lf\n",m,T,v0,H,g,Vsoft,dt);
    double A=T/m;
    double df=((A-g)*H)/A;
    printf("df=%.3lf\n",df);
    df=H-df;
    while (H>0) {
        if(H<=df) s=stavmotora(v0,Vsoft);
        printf("t=%.3lf h=%.3lf v=%.3lf s=%d\n",t,H,v0,s);
        if (s==0) a=-g;
        else a=(A-g);
        H=vyska(H,v0,dt,a);
        v0=rychlost(v0,a,dt);
        t+=dt;
        if (s==1) total=total+dt;
        s=0;
    }
    printf("t=%.3lf h=%.3lf v=%.3lf\n",t,H,v0);
    printf("total=%.3lf\n",total);
    return 0;
}
