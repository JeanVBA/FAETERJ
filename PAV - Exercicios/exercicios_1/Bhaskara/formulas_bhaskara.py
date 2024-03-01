"Importa a biblioteca para ter potencia e raiz quadrada"
from cmath import sqrt

class Formulas:
    "Classe com as formulas necessarias"
    def calculate_delta(self, numbers:list[3]):
        "Faz a conta de DELTA"
        x = sqrt(numbers[1]**2 -(4*numbers[2]*numbers[0]))
        return x
    def calculate_bhaskara(self, numbers:list[3], result_delta):
        "Fazer a soma dos valores resultantes da formula de DELTA"
        z = (-numbers[1] - result_delta)/(2*numbers[0])
        y = (-numbers[1] + result_delta)/(2*numbers[0])
        return z,y
