#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "data.h"
#include "rng.h"
#include <math.h>

void prepisSol(char *subor){
    FILE *f;
    f=fopen(subor,"r");
    int riadky=0;
    if(f==NULL) exit(2);
    while ((fscanf(f,"%s",enemy_types[riadky].name))!=EOF){
        if (strlen(enemy_types[riadky].name)>UNIT_TYPE_NAME_LEN) exit(3);
        if((fscanf(f,"%d",&enemy_types[riadky].att))==NULL) exit(3);
        if((fscanf(f,"%d",&enemy_types[riadky].def))==NULL) exit(3);
        riadky++;
        if (riadky>ENEMY_TYPE_COUNT) break;
    }
    if (riadky>ENEMY_TYPE_COUNT || riadky<ENEMY_TYPE_COUNT) exit(3);
    fclose(f);
}

void Vypisutoku(Unit Soldier[],Unit monster,int dmg,int index,int a){
    if(a==0)printf("%s => %d => [%d] %s\n",monster.type->name, dmg, index, Soldier[index].type->name);
    if(a==1)printf("[%d] %s => %d => %s\n",index, Soldier[index].type->name, dmg, monster.type->name);
}

int NOOB(Unit Soldier[],int velkost){
    int noob=0;
    while(1){
        if(Soldier[noob].hp > 0){
            break;
        }
        noob++;
    }
    for (int i=noob; i<velkost; i++) {
        if (Soldier[noob].hp > Soldier[i].hp && Soldier[i].hp>0) noob=i;
    }
    return noob;
}

int Damage(int Alevel,int Dlevel, int AHP,int Aatt,int DHP,int Ddef){
    int basedmg=30+Alevel-Dlevel;
    int strenght=100+rnd(1,AHP)+Aatt;
    int def=100+rnd(1,DHP)+Ddef;
    int dmg=(basedmg*strenght)/def;
    return dmg;
}

void vypismonster(Unit monster){
    printf("%s, ATT:%d, DEF:%d, HP:%d, LVL:%d\n", monster.type->name, monster.type->att, monster.type->def,monster.hp,monster.level);
}
void vypisSoldier(Unit Soldier[],int velkost){
    for (int i = 0; i <velkost; i++) {
        printf("[%d] %s, ATT:%d, DEF:%d, HP:%d, LVL:%d\n", i, Soldier[i].type->name, Soldier[i].type->att, Soldier[i].type->def, Soldier[i].hp, Soldier[i].level);
    }
    printf("\n");
}

int ConInt(char string[]){
    int cislo=0;
    for(int i=0;i<(int)strlen(string);i++){
        cislo=cislo+(int)(string[i]-'0')*(int)pow(10,strlen(string)-1-i);
    }
return cislo;
}

Unit GenMon(char meno[]){
    Unit monster;
    int pocet=0;
    for (int i = 0; i < 3; i++) {
        if(strcmp(monster_types[i].name,meno)==0) {
            monster.type=&monster_types[i];
            pocet++;
            break;
        }
    }
    monster.hp=MONSTER_INITIAL_HP;
    monster.level=0;
    if (pocet==0) exit(1);
    else return monster;
}

Unit GenSol(){
    Unit Soldier;
    Soldier.type=&enemy_types[rnd(0,sizeof(enemy_types)/sizeof(UnitType)-1)];
        Soldier.hp=rnd(ENEMY_MIN_INIT_HP,ENEMY_MAX_INIT_HP);
        Soldier.level=rnd(0,UNIT_MAX_LEVEL);
    return Soldier;
}

int main(int argc, char *argv[]) {
    int seed = ConInt(argv[3]);
    int velkost = ConInt(argv[2]);
    Unit monster, Soldier[velkost];
    srnd(seed);

    if (argc == 6) {
        prepisSol(argv[5]);
        }

    monster = GenMon(argv[1]);
    for (int i = 0; i < velkost; i++) {
        Soldier[i] = GenSol();
    }

        int noob, zivoty = velkost, dmg, EDMG = 0, MDMG = 0;
        while (monster.hp > 0 && zivoty > 0) {
            vypismonster(monster);
            vypisSoldier(Soldier, velkost);
            noob = NOOB(Soldier, velkost);
            dmg = Damage(monster.level, Soldier[noob].level, monster.hp, monster.type->att, Soldier[noob].hp,
                         Soldier[noob].type->def);
            MDMG += dmg;
            Vypisutoku(Soldier, monster, dmg, noob, 0);
            Soldier[noob].hp = Soldier[noob].hp - dmg;
            if (Soldier[noob].hp <= 0) zivoty--;
            for (int i = 0; i < velkost; i++) {
                if (Soldier[i].hp > 0) {
                    dmg = Damage(Soldier[i].level, monster.level, Soldier[i].hp, Soldier[i].type->att, monster.hp,
                                 monster.type->def);
                    EDMG += dmg;
                    monster.hp = monster.hp - dmg;
                    Vypisutoku(Soldier, monster, dmg, i, 1);
                    if (monster.hp <= 0) break;
                }
            }
            printf("\n");
            if (monster.level < UNIT_MAX_LEVEL && monster.hp>0) monster.level++;
        }
        vypismonster(monster);
        vypisSoldier(Soldier, velkost);
        if (monster.hp > 0) printf("Winner: %s", monster.type->name);
        else printf("Winner: Enemy");
        printf("\nTotal monster DMG: %d\nTotal enemies DMG: %d", MDMG, EDMG);
        return 0;
}
