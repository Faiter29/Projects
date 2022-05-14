#include <stdio.h>
#define R_MAX 2147483647
static long long unsigned int SEED = 0x1;

void srnd(int seed) {
    SEED = seed;
}

int rnd(int from, int to) {
    SEED = SEED * 16807 % R_MAX;
    return from + (int) SEED % (to - from + 1);
}

void zoradenie(int pole[],int velkost){
    int prepis;
    int najmensie;
    for(int i=0;i<velkost;i++){
        najmensie=pole[i];
        prepis=i;
        for(int j=i;j<velkost;j++){
            if(najmensie>pole[j]) {
                najmensie = pole[j];
                prepis=j;
            }
        }
        pole[prepis]=pole[i];
        pole[i]=najmensie;
    }
}

void genblocker(int m1,int blocker[],int n){
    int ran;
    int j;
    for(int i=0;i<m1;i++){
        j=0;
        ran=rnd(1,n-1);
        while(j<i){
            if(ran==blocker[j]) {
                ran = rnd(1, n-1);
                j=0;
            }
            else j++;
        }
        blocker[i]=ran;
    }
}

void genbooster(int m1,int m2,int booster[], int n,int blocker[]) {
    int ran;
    int j;
    for (int i = 0; i < m2; i++) {
        j=0;
        ran=rnd(1, n-1);
        while(j<=i){
            if(ran==booster[j]) {
                ran = rnd(1, n-1);
                j=0;
            }
            else j++;
            if(j>i){
                for(int k=0;k<m1;k++){
                    if(blocker[k]==ran){
                        ran = rnd(1, n-1);
                        j=0;
                        break;
                    }
                }
            }
        }
        booster[i] = ran;
    }
}

int odstranenie(int pole[],int m,int index){
    for(int i=index;i<m;i++){
    pole[i]=pole[i+1];
    }
    m=m-1;
    return m;
}
int hotspot(int pole[],int n){
    int cislo=pole[0];
    for(int i=0;i<n;i++){
        if(cislo<pole[i]) {
            cislo=pole[i];
        }
    }
    return cislo;
}

int main() {
    int seed,n,m1,m2;
    printf("Zadaj:\n");
    printf("Pociatocna hodnota pseudo-nahodnych cisiel(>0)\n");
    scanf("%d",&seed);
    printf("Dlzka zavodnej drahy (10-100)\n");
    scanf("%d",&n);
    printf("Pocet vygenerovanych Blockerov\n");
    scanf("%d",&m1);
    printf("Pocet vygenerovanych boosterov\n");
    scanf("%d",&m2);
    //scanf("%d %d %d %d",&seed,&n,&m1,&m2);
    srnd(seed);
    int raketa1[]={-1,0};
    int raketa2[]={-1,0};
    int blocker[m1];
    int booster[m2];
    int aktiv[]={-1,0};
    int pole[n];
    for (int i=0;i<n;i++){
        pole[i]=0;
    }
    int hrac;
    int tah=0;
    int r1;
    int r2;
    int posun;
    if (100>=n && n>=10 && seed>0 && ((m1+m2)<=n/2)){
        genblocker(m1,blocker,n);
        genbooster(m1,m2,booster,n,blocker);
        zoradenie(booster,m2);
        zoradenie(blocker,m1);
        printf("BLOCK:");
        for(int i=0;i<m1;i++){
            printf("%d ",blocker[i]);}
        printf("\nBOOST:");
        for(int i=0;i<m2;i++){
            printf("%d ",booster[i]);}
        //zacina hra
        printf("\n");
        while(raketa1[0]<n && raketa2[0]<n){
            tah++;
            if(tah%2==1){
                hrac=1;
                printf("[%d,%d] ",tah,hrac);
                printf("[%d,%d] ",raketa1[0],raketa1[1]);
                for(int i=0;i<2;i++) {
                    aktiv[i] = raketa1[i];
                }
            }
            else {
                hrac=2;
                printf("[%d,%d] ", tah,hrac);
                printf("[%d,%d] ", raketa2[0], raketa2[1]);
                for (int i = 0; i < 2; i++) {
                    aktiv[i] = raketa2[i];
                }
            }
            r1=rnd(1,6);
            r2=rnd(1,6);
            printf("[%d,%d] ",r1,r2);
            if(aktiv[0]==-1 && r1+r2>7){//mimo pola
                aktiv[0]=r1+r2-7+aktiv[1];
            }
            else if(aktiv[0]==-1 && r1+r2<=7){
            }
            else if(aktiv[0]==raketa1[0] && aktiv[0]<raketa2[0] && r1+r2==12 && raketa1[0]>-1 && raketa2[0]>-1){ //vymena hracov
                aktiv[0]=raketa2[0];
                raketa2[0]=raketa1[0];
                pole[raketa2[0]]=pole[raketa2[0]]+1;
                posun=0;
            }
            else if(aktiv[0]==raketa2[0] && aktiv[0]<raketa1[0] && r1+r2==12 && raketa1[0]>-1 && raketa2[0]>-1){ //vymena hracov
                aktiv[0]=raketa1[0];
                raketa1[0]=raketa2[0];
                pole[raketa1[0]]=pole[raketa1[0]]+1;
                posun=0;
            }
            else if(aktiv[0]==raketa1[0] && aktiv[0]>raketa2[0] && r1+r2==2 && raketa1[0]>-1 && raketa2[0]>-1){ //vymena hracov
                aktiv[0]=raketa2[0];
                raketa2[0]=raketa1[0];
                pole[raketa2[0]]=pole[raketa2[0]]+1;
                posun=0;
            }
            else if(aktiv[0]==raketa2[0] && aktiv[0]>raketa1[0] && r1+r2==2 && raketa1[0]>-1 && raketa2[0]>-1){ //vymena hracov
                aktiv[0]=raketa1[0];
                raketa1[0]=raketa2[0];
                pole[raketa1[0]]=pole[raketa1[0]]+1;
                posun=0;
            }
            else{//posun
                if(r1>=r2) posun=r1;
                else posun=r2;
                aktiv[0]=aktiv[0]+posun+aktiv[1];
            }
            if (aktiv[0]>=0) pole[aktiv[0]]=pole[aktiv[0]]+1;
            for(int i=0;i<m2;i++) {
                if (aktiv[0]==booster[i]){
                    aktiv[1]=aktiv[1]+1;
                    m2=odstranenie(booster,m2,i);
                    break;
                }
            }
            for(int i=0;i<m1;i++){
                if(aktiv[0]==blocker[i]){
                    if (aktiv[1]>0){
                        aktiv[1]=0;
                    }
                    else{
                        aktiv[0]=-1;
                    }
                    m1=odstranenie(blocker,m1,i);
                    break;
                }
            }
            if(aktiv[0]==raketa1[0] && hrac==2) raketa1[0]=-1;
            if(aktiv[0]==raketa2[0] && hrac==1) raketa2[0]=-1;
            if(tah%2==1) {
                for (int i = 0; i < 2; i++) {
                    raketa1[i] = aktiv[i];
                }
                printf("[%d,%d]", raketa1[0], raketa1[1]);
            }
            if(tah%2==0) {
                for (int i = 0; i < 2; i++) {
                    raketa2[i] = aktiv[i];
                }
                printf("[%d,%d]", raketa2[0], raketa2[1]);
            }
            printf("\n");
        }
        printf("WINNER:%d\n",hrac);
        printf("HOTSPOT:%d",hotspot(pole,n));
        return 0;
    }
    else return 1;
}
