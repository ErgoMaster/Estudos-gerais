#include <iostream>
#include <list>
#include <queue> // fila para usar na BFS

using namespace std;

class Grafo {
	int V; // número de vértices
	list<int> *adj; // ponteiro para um array contendo as listas de adjacências

public:
	Grafo(int V); // Construtor
	void adicionarAresta(int v1, int v2); // Adiciona uma aresta no grafo

	// Faz uma BFS a partir de um vértice de origem e outro de parada
	void bfs(int v, int k);
};

Grafo::Grafo(int V) {
	this->V = V; // atribui o número de vértices
	adj = new list<int>[V]; // cria as listas
}

void Grafo::adicionarAresta(int v1, int v2) {
	// Adiciona vértice v2 à lista de vértices adjacentes de v1
	adj[v1].push_back(v2);
}

void Grafo::bfs(int verticeOrigem, int verticeParada)
{
	queue<int> fila;
	bool visitados[V]; // Vetor de visitados

	for(int i = 0; i < V; i++)
		visitados[i] = false;

	cout << "Visitando vertice " << verticeOrigem << " ...\n";
	visitados[verticeOrigem] = true; // Marca como visitado

	while(true) {
		list<int>::iterator it;
		for(it = adj[verticeOrigem].begin(); it != adj[verticeOrigem].end(); it++) {
			if(!visitados[*it] && visitados[verticeParada] != true) {
				cout << "Visitando vertice " << *it << " ...\n";
				visitados[*it] = true; // Marca como visitado
				fila.push(*it); // Insere na fila
			}
		}

		// Verifica se a fila não está vazia
		if(!fila.empty()) {
			verticeOrigem = fila.front(); // Obtém o primeiro elemento
			fila.pop(); // Remove da fila
		}
		else { break; }
	}
}

int main()
{
	int V = 8;

	Grafo grafo(V);

	// Adicionando as arestas
	grafo.adicionarAresta(0, 1);
	grafo.adicionarAresta(0, 3);
	grafo.adicionarAresta(1, 2);
	grafo.adicionarAresta(1, 3);
	grafo.adicionarAresta(2, 5);
    grafo.adicionarAresta(3, 2);
	grafo.adicionarAresta(3, 5);
	grafo.adicionarAresta(5, 4);
    grafo.adicionarAresta(5, 4);
    grafo.adicionarAresta(4, 2);

	grafo.bfs(0, 3);

	return 0;
}