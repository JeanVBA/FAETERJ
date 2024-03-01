import sys
sys.path.append('')
from Quadrado import Quadrado
from Triangulo import Triangulo
from Circulo import Cirgulo

def selecao_area():
    while True:
        ESCOLHA = int(input("1 - Area do QUADRADO\n"+
                        "2 - Area do TRIANGULO\n"+
                        "3 - Area do CIRCULO\n"
                        "4 - Sair\n"
                        "Escolha a operação desejada:"))
        if ESCOLHA == 1:
            area = Quadrado(float(input("Digite o lado do quadrado:")))
            print(f"Area do quadrado:{Quadrado.get_area(area)}")
        if ESCOLHA == 2:
            area = Triangulo(float(input("Digite a base:")), float(input("Dgite a altura:")))
            print(f"Area do triangulo:{Triangulo.get_area(area)}")
        if ESCOLHA == 3:
            area = Cirgulo(float(input("Digite o raio:")))
            print(f"Area do circulo:{Cirgulo.get_area(area)}")
        if ESCOLHA == 4:
            break
