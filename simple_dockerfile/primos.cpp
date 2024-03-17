#include <iostream>

bool esPrimo(int num) {
    if (num <= 1) {
        return false;
    }
    for (int i = 2; i * i <= num; ++i) {
        if (num % i == 0) {
            return false;
        }
    }
    return true;
}

int main() {
    int numero;

    std::cout << "Ingrese un numero: ";
    std::cin >> numero;

    if (esPrimo(numero)) {
        std::cout << numero << " es un numero primo." << std::endl;
    } else {
        std::cout << numero << " no es un numero primo." << std::endl;
    }

    return 0;
}