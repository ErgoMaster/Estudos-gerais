#include <iostream>
#include <list>
#include <queue>
#include <vector>

using namespace std;

class Grafo {
private:
    int n; // Número de vértices
    list<int> *adj; // Lista de adjacência

public: 
    Grafo(int n);
    void adicionarAresta(int v1, int v2);
    void Kahn();
};

Grafo::Grafo(int n) {
    this->n = n; 
    adj = new list<int>[n]; // Cria lista de adjacência de tamanho n
}

void Grafo::adicionarAresta(int v1, int v2) {
    // Adiciona v2 a lista de vértices adjacentes a v1
    adj[v1].push_back(v2);
}

void Grafo::Kahn() {
    vector<int> in_degree(n, 0); // Vetor com as adjacências de entrada

    // Adicionando as adjacências de entrada no vetor pela lista de adjacência
    for(int i = 0; i < n; i++) {
        list<int>::iterator itr;
        for(itr = adj[i].begin(); itr != adj[i].end(); itr++) {
            in_degree[*itr]++;
        }
    }

    queue<int> fila; // Declaração da fila que servirá de auxilio

    // Adicionando os primeiros vértices que não possuem arcos de entrada
    for(int i = 0; i < n; i++) {
        if(in_degree[i] == 0) {
            fila.push(i);
        }
    }

    // Index para auxilio e vetor ordem para a sequência final
    int index = 0;
    vector<int> ordem;

    // Loop while para se iniciar o algoritmo de fato
    while(!fila.empty()) {
        int aux = fila.front();
        fila.pop();
        ordem.push_back(aux);

        // Atualizando as adjacências após a retirada de um vértice do grafo
        list<int>::iterator itr;
        for(itr = adj[aux].begin(); itr != adj[aux].end(); itr++) {
            in_degree[*itr]--;

            if(in_degree[*itr] == 0) {
                fila.push(*itr);
            }
        }
        index++;
    }

    // Verificação da existência ou não de ciclos
    if(index != n) {
        cout << "Ha ciclos!";
        return;
    } 

    // Imprimir a sequência
    for(int i = 0; i < ordem.size(); i++) {
        cout << ordem[i] << " ";
    }

}

int main() {
    Grafo grafo(5);

    grafo.adicionarAresta(0, 1);
    grafo.adicionarAresta(0, 2);
    grafo.adicionarAresta(1, 3);
    grafo.adicionarAresta(1, 4);
    grafo.adicionarAresta(2, 3);
    grafo.adicionarAresta(2, 4);

    cout << "Ordenação topológica:" << endl;
    grafo.Kahn();

    return 0;
}