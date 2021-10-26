#include <iostream>
#include <iomanip>

using namespace std;

struct Aresta {
    int pai;
    int filho;
    int peso;
};

struct Grafo {
    int V; // Número de vértices
    int E; // Número de arestas

    struct Aresta* aresta;
};

struct Grafo* criarGrafo(int V, int E) {
    // Cria um grafo com V vértices e E arestas
    struct Grafo* grafo = new Grafo;
    grafo->V = V;
    grafo->E = E;
    grafo->aresta = new Aresta[E];

    return grafo;
};

void imprimeResultado(int distancias[], int n) {
    // Imprime o vetor com os resultados, com n vértices
    cout << "Vertice  Distancia do vertice de origem" << endl;

    for(int i = 0; i < n; i++) {
        cout << setw(4) << i << setw(20) << distancias[i] << endl;
    }
}

void bellmanFord(struct Grafo* grafo, int verticeOrigem) {
    int V = grafo->V;
    int E = grafo->E;
    int distancias[V];

    // Inicializar todas as distâncias como infinito, exceto o grafo de origem
    for(int i = 0; i < V; i++) {
        distancias[i] = INT32_MAX;
    }
    distancias[verticeOrigem] = 0;

    // Processo de relaxamento das arestas e atribuição das distâncias 
    for(int i = 0; i < V; i++) {
        for(int j = 0; j < E; j++) {
            int verticePai = grafo->aresta[j].pai;
            int verticeFilho = grafo->aresta[j].filho;
            int peso = grafo->aresta[j].peso;

            if(distancias[verticePai] != INT32_MAX && distancias[verticePai] + peso < distancias[verticeFilho]) {
                distancias[verticeFilho] = distancias[verticePai] + peso;
            } 
        }
    }

    // Segundo loop para a verificação de ciclos negativos
    for(int j = 0; j < E; j++) {
        int verticePai = grafo->aresta[j].pai;
        int verticeFilho = grafo->aresta[j].filho;
        int peso = grafo->aresta[j].peso;

        if(distancias[verticePai] != INT32_MAX && distancias[verticePai] + peso < distancias[verticeFilho]) {
            cout << "Esse grafo contém um ciclo negativo";
            return;
        }
    }

    imprimeResultado(distancias, V);
    return;
}

int main() {
    int V = 7; // Número de vértices
    int E = 12; // Número de arestas
    struct Grafo* grafo = criarGrafo(V, E);

    // Adicionando arestas e seus pesos
    // Aresta 0-1
    grafo->aresta[0].pai = 0;
    grafo->aresta[0].filho = 1;
    grafo->aresta[0].peso = 2;

    // Aresta 0-2
    grafo->aresta[1].pai = 0;
    grafo->aresta[1].filho = 2;
    grafo->aresta[1].peso = 7;

    // Aresta 0-4
    grafo->aresta[2].pai = 0;
    grafo->aresta[2].filho = 4;
    grafo->aresta[2].peso = 12;

    // Aresta 1-3
    grafo->aresta[3].pai = 1;
    grafo->aresta[3].filho = 3;
    grafo->aresta[3].peso = 2;

    // Aresta 2-1
    grafo->aresta[4].pai = 2;
    grafo->aresta[4].filho = 1;
    grafo->aresta[4].peso = 3;

    // Aresta 2-3
    grafo->aresta[5].pai = 2;
    grafo->aresta[5].filho = 3;
    grafo->aresta[5].peso = 1;

    // Aresta 2-4
    grafo->aresta[6].pai = 2;
    grafo->aresta[6].filho = 4;
    grafo->aresta[6].peso = 2;

    // Aresta 3-5
    grafo->aresta[7].pai = 3;
    grafo->aresta[7].filho = 5;
    grafo->aresta[7].peso = 2;

    // Aresta 4-6
    grafo->aresta[8].pai = 4;
    grafo->aresta[8].filho = 6;
    grafo->aresta[8].peso = 7;

    // Aresta 4-0
    grafo->aresta[9].pai = 4;
    grafo->aresta[9].filho = 0;
    grafo->aresta[9].peso = 7;

    // Aresta 5-6
    grafo->aresta[10].pai = 5;
    grafo->aresta[10].filho = 6;
    grafo->aresta[10].peso = 2;

    // Aresta 6-3
    grafo->aresta[11].pai = 6;
    grafo->aresta[11].filho = 3;
    grafo->aresta[11].peso = 1;

    bellmanFord(grafo, 0);
    return 0;
}