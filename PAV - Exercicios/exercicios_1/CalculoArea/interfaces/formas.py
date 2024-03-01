from abc import ABC, abstractmethod

class IFormas(ABC):
    @abstractmethod
    def get_area(self) -> float:
        pass