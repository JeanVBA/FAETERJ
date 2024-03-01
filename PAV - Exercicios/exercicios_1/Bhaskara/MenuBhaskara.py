"Local das formulas"
from exercicios_1.Bhaskara.formulas_bhaskara import Formulas

def implementacao_bhaskara():
    "Implementação da bhaskara"
    values = []
    for i in range(3):
        value = float(input("Escreva os valores:"))
        values.append(value)

    delta = Formulas.calculate_delta(0, values)

    if delta.imag == 0:  # Verifica se a parte imaginária de delta é zero
        value1, value2 = Formulas.calculate_bhaskara(0, values, delta)
        value1_formatted = value1.real if value1.imag == 0 else value1
        value2_formatted = value2.real if value2.imag == 0 else value2
        print(f"X = {value1_formatted}\nX = {value2_formatted}")
    else:
        print("A equação não possui soluções reais.")
