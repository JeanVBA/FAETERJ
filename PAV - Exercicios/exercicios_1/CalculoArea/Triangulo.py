from interfaces.formas import IFormas

class Triangulo(IFormas):
    def __init__(self, base:float, altura:float) -> None:
        self.base = base
        self.altura = altura
    def get_area(self) -> float:
        area = (self.base*self.altura)/2
        return area