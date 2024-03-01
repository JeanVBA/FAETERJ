from interfaces.formas import IFormas

class Cirgulo(IFormas):
    def __init__(self, raio:float) -> None:
        self.raio = raio
    def get_area(self) -> float:
        area = 3.14159 * self.raio**2
        return area