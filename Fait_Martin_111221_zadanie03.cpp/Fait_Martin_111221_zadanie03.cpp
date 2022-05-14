/*
Meno a priezvisko:
Martin Fait

POKYNY:
(1)  Implementujte funkcie tak, aby splnali popis pri ich deklaraciach.
(2)  Cela implementacia musi byt v tomto jednom subore.
(3)  Odovzdajte len tento zdrojovy subor (dopleny o riesenia).
(4)  Program musi byt kompilovatelny.
(5)  Globalne a staticke premenne su zakazane.
(6)  V ziadnom pripade nemente deklaracie funkcii, ktore mate za ulohu naprogramovat
     (nemente nazvy, navratove hodnoty, ani typ a pocet parametrov v zadanych funkciach).
     Nemente implementacie zadanych datovych typov, ani implementacie hotovych pomocnych funkcii
     (ak nie je v zadani ulohy uvedene inak).
(7)  V pripade potreby mozete kod doplnit o dalsie pomocne funkcie alebo datove typy.
(8)  Vase riesenie otestujte (vo funkcii 'main' a pomocou doplnenych pomocnych funkcii alebo datovych typov).
     Testovaci kod ale nebude hodnoteny.
(9) Funkcia 'main' musi byt v zdrojovom kode posledna.
*/

#include <iostream>
#include <cstring>

using namespace std;

//-------------------------------------------------------------------------------------------------
// DATOVE TYPY
//-------------------------------------------------------------------------------------------------

// Uzol zretazeneho zoznamu
struct Node {
    int data; // hodnota uzla
    Node* next; // smernik na dalsi uzol zoznamu
};

// Zretazeny zoznam
struct List {
    Node* first; // smernik na prvy uzol zoznamu
};

int POCETpismen(const char *slovo){
    int index=0;
    while (slovo[index]!='\0'){
        index++;
    }
    return index;
}

Node *create(const int value){
    Node* new_Node= new Node;
    new_Node->data=value;
    new_Node->next= nullptr;
    return new_Node;
}

void pridanie(List *list, const int v){
    Node* a=create(v);
    a->next=list->first;
    list->first=a;
}
//-------------------------------------------------------------------------------------------------
// 1. ULOHA (0.8 bodu)
//-------------------------------------------------------------------------------------------------
/*
    Funkcia usporiada pole 'data' od najvacsieho prvku po najmensi prvok.
    Pouzite algoritmus insertion sort.

    PARAMETRE:
        [in, out] data - pole, ktore funkcia usporiada
        [in] length    - pocet prvkov pola

    VSTUPNE PODMIENKY:
        'length' moze mat lubovolnu hodnotu
        'data' ukazuje na platne pole

    PRIKLADY:
        {1, 3, 2} -> {3, 2, 1}
        {1, 2, 2, 1} -> {2, 2, 1, 1}
        {1} -> {1}
        {} -> {}
*/
void insertionSort(int *data, const size_t length) {
    int a;
    for (size_t i = 0; i <length ; ++i) {
        size_t j=i;
        a=data[i];
        while(a>data[j-1] && j>0){
            data[j]=data[j-1];
            --j;
        }
        data[j]=a;
    }

 //   for (size_t i = 0; i < length; i++) {
 //       std::cout<<*(data+i)<<",";
 //   }
 //   std::cout<<std::endl;
}

//-------------------------------------------------------------------------------------------------
// 2. ULOHA (0.8 bodu)
//-------------------------------------------------------------------------------------------------
/*
    Funkcia usporiada textove retazce v poli 'data' od najvacsieho prvku po najmensi (lexikograficky).
    Preusporiadajte smerniky v poli.
    Pouzite algoritmus insertion sort.

    PARAMETRE:
        [in, out] data - pole, ktore funkcia usporiada.
                Pole obsahuje smerniky na textove retazce.
                Kazdy textovy retazec je ukonceny '\0'.
                Posledny smernik ma hodnotu 'nullptr'. Podla toho urcite pocet prvkov pola (pocet textovych retazcov).

    VSTUPNE PODMIENKY:
        'data' obsahuje minimalne jeden smernik.
        Posledny smernik ma hodnotu 'nullptr'.

    PRIKLADY:
        {"Juraj", "Peter", "Andrej", nullptr} -> {"Peter", "Juraj", "Andrej", nullptr}
        {"Juraj", "Anabela", "Peter", "Andrej", nullptr} -> {"Peter", "Juraj", "Andrej", "Anabela", nullptr}
        {"Andrej", "Juraj", "Andrej", nullptr} -> {"Juraj", "Andrej", "Andrej", nullptr}
        {"Andrej", nullptr} -> {"Andrej", nullptr}
        {nullptr} -> {nullptr}

    POZNAMKY:
        Pri testovani mozete jednoducho pole vytvorit nasledovnym sposobom:
        const char *mena[] = {"Juraj", "Peter", "Andrej", nullptr};

        Na porovnanie obsahu textovych retazcov vyuzite prislusnu funkciu zo standardnej kniznice.
*/
void insertionSort(const char *data[]) {
    int pocet = 0;
    int index=0;
    const char *slovo;

    while (data[pocet] != nullptr) {
        pocet++;
    }

    for (int i = 0; i <pocet ; i++) {
        int j=i;
        slovo=data[i];
        while(j>0 ){
              while (slovo[index] == (int)(data[j-1][index]) &&(slovo[index]!='\n' || data[j-1][index]!='\n') ){
                  index++;
              }
              if((int)slovo[index]<=(int)(data)[j-1][index]) break;
              data[j]=data[j-1];
                --j;
        }
        data[j]=slovo;
        index=0;
    }

 //   for (int i = 0; i < pocet; i++) {
 //       std::cout << data[i];
 //       std::cout << ",";
//    }
  //  std::cout<<std::endl;
}

//-------------------------------------------------------------------------------------------------
// 3. ULOHA (0.8 bodu)
//-------------------------------------------------------------------------------------------------
/*
    Funkcia usporiada zretazeny zoznam 'list' od najvacsieho prvku po najmensi.
    Preusporiadajte uzly v zozname (nekopirujte hodnoty v uzloch).
    Pouzite algoritmus insertion sort.

    PARAMETRE:
        [in, out] list - zretazeny zoznam, ktory funkcia usporiada

    VSTUPNE PODMIENKY:
        'list' obsahuje lubovolny pocet uzlov (moze byt prazdny)
        'list' nie je 'nullptr'

    PRIKLADY:
        vstup: 2->1->3,        vystup: 3->2->1
        vstup: 1->2->2->1,     vystup: 2->2->1->1
        vstup: prazdny zoznam, vystup: prazdny zoznam
*/
void insertionSort(List * list) {
    Node * to=list->first;
    Node * daco=to;
    Node * zoradenie= nullptr;

    while (daco!= nullptr){
        Node *dalsie=daco;
        daco=daco->next;
        if(zoradenie== nullptr || zoradenie->data<dalsie->data){
            dalsie->next=zoradenie;
            zoradenie=dalsie;
        }
        else{
            Node *a=zoradenie;
            while (a!= nullptr){
                if(a->next== nullptr || a->next->data<dalsie->data){
                    dalsie->next=a->next;
                    a->next=dalsie;
                    break;
                }
                a=a->next;
            }
        }
    }
    list->first=zoradenie;
    //zoradenie=list->first;
    //while (zoradenie!= nullptr){
    //    std::cout<<zoradenie->data<<",";
    //    zoradenie=zoradenie->next;
    //}
}

//-------------------------------------------------------------------------------------------------
// 4. ULOHA (0.8 bodu)
//-------------------------------------------------------------------------------------------------
/*
    Funkcia vykona algoritmus merge (cast algoritmu merge sort), ktory ma linearnu vypoctovu zlozitost.
    Kombinuje dve susedne, usporiadane casti v poli 'input', do jednej usporiadanej casti v poli 'output'.
    Usporiadanie je od najvacsieho prvku po najmensi prvok!

    PARAMETRE:
        [out] output - vystupne pole, ktoreho cast output[low]...output[high-1] bude po vykonani funkcie usporiadana
        [in]  input  - vstupne pole, ktoreho casti input[low]...input[middle-1] a input[middle]...input[high-1]
                         musia byt pri volani funkcie usporiadane od najvacsieho prvku po najmensi
        [in]  low    - index 1. prvku lavej usporiadanej casti pola 'input'
        [in]  middle - index 1. prvku pravej usporiadanej casti pola 'input'
        [in]  high   - index za poslednym prvkom pravej usporiadanej casti pola 'input'

    VYSTUPNE PODMIENKY:
        Obsah 'input' je nezmeneny.
        output[low] ... output[high-1] obsahuje usporiadane prvky z input[low] ... input[high-1], zvysne prvky v 'output' funkcia nemeni.
        Prvky s indexami mensimi ako 'low' sa nemenia (ani v jednom poli).
        Prvky s indexami vacsimi alebo rovnymi ako 'high' sa nemenia (ani v jednom poli).

    PRIKLAD:
        low: 4
        middle: 8
        hight: 12
        input:                         {10, 10, 10, 10,  7,  5,  2,  0,  8,  4,  2,  1, 10, 10, 10, 10}
        output pred vykonanim funkcie: {20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20}
        output po vykonani funkcie:    {20, 20, 20, 20,  8,  7,  5,  4,  2,  2,  1,  0, 20, 20, 20, 20}
*/
void merge(int* output, const int* input, const size_t low, const size_t middle, const size_t high)
{
    size_t prvy=low;
    size_t druhy=middle;
    size_t vysledok=low;

    while (prvy<middle && druhy<high){
        if (input[prvy]>= input[druhy]){
            output[vysledok]=input[prvy];
            prvy++;
        }
        else{
            output[vysledok]=input[druhy];
            druhy++;
        }
        vysledok++;
    }

    while (prvy<middle){
        output[vysledok]=input[prvy];
        prvy++;
        vysledok++;
    }
    while (druhy<high){
        output[vysledok]=input[druhy];
        druhy++;
        vysledok++;
    }

    //for (int i = 0; i < 16; i++) {
    //    std::cout<<output[i]<<",";
    //}
}


void mergeSortRecurziva(int * A,int * B,size_t min,const size_t max){
    if (min+1>=max){
        return;
    }
    else{
        const size_t stred=(max+min)/2;
        mergeSortRecurziva(B,A,min,stred);
        mergeSortRecurziva(B,A,stred,max);
        merge(A,B,min,stred,max);
    }
}

//-------------------------------------------------------------------------------------------------
// 5. ULOHA (0.8 bodu)
//-------------------------------------------------------------------------------------------------
/*
    Funkcia usporiada prvky v poli 'data' od najvacsieho prvku po najmensi.
    Pouzite algoritmus merge sort.

    PARAMETRE:
        [in, out] data - pole, ktore funkcia usporiada
        [in] length    - pocet prvkov pola

    VSTUPNE PODMIENKY:
        'data' ukazuje na platne pole

    PRIKLADY:
        {1, 3, 2} -> {3, 2, 1}
        {1, 2, 2, 1} -> {2, 2, 1, 1}
        {1} -> {1}
        {} -> {}

    POZNAMKA:
        Ak pouzijete pristup top-down, tak
        - v tejto funkcii zabezpecte vytvorenie a kopirovanie dat do pomocneho pola,
        - vytvorte a zavolajte rekurzivnu funkciu, v ktorej implementujete hlavnu cast algoritmu merge sort.
*/
void mergeSort(int *data, const size_t length) {
    int *daco= new int[length];
    std::copy(data, data+length,daco);
    mergeSortRecurziva(data, daco,0,length);
    delete []daco;
}

//-------------------------------------------------------------------------------------------------
// TESTOVANIE
//-------------------------------------------------------------------------------------------------

// tu mozete doplnit pomocne funkcie a struktury

int main() {
    //int mego[]={10, 10, 10, 10,  7,  5,  2,  0,  8,  4,  2,  1, 10, 10, 10, 10};
    //int mego2[]={20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20};
    //merge(mego2,mego,4,8,12);
 //   int pole[]={5,6,8,1,0};
  //  int pole1[]={1,2,6,1};
    //List *list=new List;
    //list->first= nullptr;
    //int pole2[]={1,3,2};
    //for (int i = 0; i < 4; i++) {
    //    pridanie(list,pole2[i]);
    //}
    //mergeSort(pole2,1);
    //for (int i = 0; i < 1; i++) {
    //    std::cout<<pole2[i];
    //}
    //Node *daco=list->first;
    //while (daco!= nullptr){
    //    std::cout<<daco->data<<",";
    //    daco=daco->next;
    //}
//    std::cout<<std::endl;
//    insertionSort(list);*/
//    daco=list->first;
//    while (daco!= nullptr){
//        std::cout<<daco->data<<",";
//        daco=daco->next;
//    }
   // std::cout<<""<<std::endl;
  //  insertionSort(list);
   // insertionSort(pole,5);
  //  insertionSort(pole1,4);
  //  insertionSort(pole2,6);
//    const char *mena[] = {"Juraj", "Peter", "Andrej", nullptr};
//    const char *mena2[]={"Juraj", "Anabela", "Peter", "Andrej", nullptr};
//    const char *mena3[]={"Andrej", "Juraj", "Andrej", nullptr};
//    const char *mena4[]={"Andrej", nullptr};
//    const char *mena5[]={nullptr};

//    {"Juraj", "Peter", "Andrej", nullptr} -> {"Peter", "Juraj", "Andrej", nullptr}
//    {"Juraj", "Anabela", "Peter", "Andrej", nullptr} -> {"Peter", "Juraj", "Andrej", "Anabela", nullptr}
//    {"Andrej", "Juraj", "Andrej", nullptr} -> {"Juraj", "Andrej", "Andrej", nullptr}
//    {"Andrej", nullptr} -> {"Andrej", nullptr}
//    {nullptr} -> {nullptr}

   /* insertionSort(mena);
    for (int i = 0; i < 3; i++) {
        std::cout << mena[i];
        std::cout << ",";
    }
    std::cout << ""<<std::endl;

    insertionSort(mena2);
    for (int i = 0; i < 4; i++) {
        std::cout << mena2[i];
        std::cout << ",";
    }
    std::cout << ""<<std::endl;

    insertionSort(mena3);
    for (int i = 0; i < 3; i++) {
        std::cout << mena3[i];
        std::cout << ",";
    }
    std::cout << ""<<std::endl;

    insertionSort(mena4);
    for (int i = 0; i < 1; i++) {
        std::cout << mena4[i];
        std::cout << ",";
    }
    std::cout << ""<<std::endl;

    insertionSort(mena5);
    for (int i = 0; i <1; i++) {
        std::cout << mena5[i];
        std::cout << ",";
    }*/
    return 0;
}
