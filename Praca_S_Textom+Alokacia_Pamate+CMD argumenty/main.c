#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <ctype.h>
#include <memory.h>

char* zvacsipole(char *pole, int dlzka, char nasledujuce){
    char *pomoc=malloc(dlzka+1);
    strcpy(pomoc,pole);
    *(pomoc+dlzka-1)=nasledujuce;
    *(pomoc+dlzka)='\0';
    //*pole=*pomoc;
    return pomoc;
}
char *readline() {
    const size_t BSIZE = 100;
    char *line = NULL;
    size_t capacity = 0;
    do {
        capacity += BSIZE;
        line = (char *) realloc(line, (capacity + 1) * sizeof(char));
        if (line == NULL)
            return line;
        if (fgets(line + capacity - BSIZE, BSIZE + 1, stdin) == NULL) {
            free(line);
            return NULL;
        }
    } while (strlen(line + capacity - BSIZE) >= BSIZE
             && line[capacity - 1] != '\n');
    return line;
}

int main(int argc, char *argv[]) {
    int opt;
    int a=0,c=0,u=0,cislo=0,r=0;
    char* optstring = ":aculr:";
    char *parameter=NULL;
    char *pomoc;
    int pocet=0;
    char pismeno;
    while ((opt = getopt(argc, argv, optstring)) != -1) {
        switch (opt) {
            case 'a':
                a++;
                break;
            case 'r':
                r++;
                parameter=optarg;
                break;
            case 'c':
                c++;
                break;
            case 'u':
                u++;
                break;
            case 'l':
                cislo++;
                break;
            case '?':
                return 1;
            case ':':
                return 2;
        }
    }

    if (u==1 && cislo==1) {
        return 3;
    }
    char *text=NULL;
    int k=optind;
   // int pocet_medzier=0;
   // int dlzka_textu;
   // int dlzka_pospace;
    while ((text=readline())!=NULL){
   //     dlzka_pospace=strlen(text)-2;
     //   while(*(text+dlzka_pospace)==' '){
       //     pocet_medzier++;
     //       dlzka_pospace--;
       // }
     //   dlzka_textu=strlen(text);
        if (text[0]=='\n') break;
        if(a==1){//NONALFA
            for(int i=0;i<strlen(text)-1;i++){
                if (isalpha(text[i])) text[i]=text[i];
                else text[i]=' ';
            }
       //     while (*(text+dlzka_textu-pocet_medzier-2)==' ' && dlzka_pospace<=dlzka_textu-pocet_medzier){
         //       *(text+dlzka_textu-pocet_medzier+1-2)='\n';
           //     *(text+dlzka_textu-pocet_medzier+1-2)='\0';
             //   dlzka_textu--;
            //}
           // text[strlen(text)-1]='\n';
  //          printf("%d",strlen(text));
        }
        if(c==1){//IBAALFA
            int j=0;
            for(int i=0;i<strlen(text)-1;i++) {
                if (isalpha(text[i])) {
                    text[j] = text[i];
                    j++;
                }
            }
            text[j]='\n';
            text[j+1]='\0';
        }
        if(u==1){//UP
            for(int i=0;i<strlen(text);i++) {
                if (islower(text[i])) text[i]=toupper(text[i]);
            }
        }
        if(cislo==1){//DOWN
            for(int i=0;i<strlen(text);i++){
                if (isupper(text[i])) text[i]=tolower(text[i]);
            }
        }
        if(r==1 && parameter!=NULL) {
            for (int i = k; i < argc; i++) {
               pocet=0;
                while (strstr((text + pocet), argv[i])) {
                    pomoc = (strstr((text + pocet), argv[i]));
                    if (strlen(parameter) > strlen(argv[i])) a = strlen(parameter);
                    else a = strlen(argv[i]);
                    for (int j = a - 1; j >= 0; j--) {
                        if (strlen(argv[i]) < strlen(parameter)) {
                           if (j >= strlen(argv[i])) {
                                text = zvacsipole(text, strlen(text) + 1, *(parameter+j));
                                pomoc = strstr((text + pocet), argv[i]);
                                for (int k = 0; k < strlen(pomoc) - strlen(argv[i]); k++) {
                                    pismeno = *(pomoc + k + strlen(argv[i]));
                                    *(pomoc + k + strlen(argv[i])) = *(text + strlen(text) - 1);
                                    *(text + strlen(text) - 1) = pismeno;
                                }
                           }
                           else *(pomoc + j) = *(parameter+j);
                        }
                        else /*if (strlen(hladane)>strlen(nahrada))*/{
                            if (j < strlen(parameter)) *(pomoc + j) = *(parameter + j);
                            else {
                                for (int k = j; k < strlen(pomoc); k++) {
                                    *(pomoc + k) = *(pomoc + k + 1);
                                }
                            }
                        }
                    }
                    pocet = strlen(text) -strlen(pomoc) + strlen(parameter);
                }
            }
        }
        if (r==0 && k>0) {
            for (int i=k; i<argc; i++) {
                pomoc = text;
                while ((pomoc) < ((text + strlen(text)) - 1)) {
                    if (strstr(pomoc, argv[i])) {
                        pomoc = ((strstr(pomoc, argv[i])));
                        int a=(strlen(argv[i]));
                        for (int i=0; i<a; i++) {
                            *pomoc='*';
                            pomoc++;
                        }
                    }
                    else break;
                }
            }
        }
        printf("%s",text);
        free(text);
    }
    return 0;
}
