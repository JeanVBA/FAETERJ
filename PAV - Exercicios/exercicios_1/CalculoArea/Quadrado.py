from interfaces.formas import IFormas

class Quadrado(IFormas):
    def __init__(self, lado:float) -> None:
        self.lado = lado
    def get_area(self) -> float:
        area = self.lado*self.lado
        return area
