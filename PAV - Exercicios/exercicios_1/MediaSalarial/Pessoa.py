
class registro_pessoa():
    def __init__(self, idade:int,sexo: str, salario:float, n_filhos:int) -> None:
        self.idade = idade
        self.sexo = sexo
        self.salario = salario
        self.n_filhos = n_filhos
    def salario_medio(self, pessoas:list) -> float:
        for pessoa in pessoas:
           salario_media = [pessoa.salario]
        media = sum(salario_media) /len(pessoas)
        return media
    def menor_idade(self, pessoas:list) -> int:
        for pessoa in pessoas:
            menor_idade = [pessoa.idade]
        idade = min(menor_idade)
        return idade
    def maior_idade(self, pessoas:list):
        for pessoa in pessoas:
            menor_idade = [pessoa.idade]
        idade = max(menor_idade)
        return idade
    def mulheres_tres_filhos_ate_500(self,pessoas: list) -> list:
        mulheres = [pessoa for pessoa in pessoas if pessoa.sexo == 'F' and pessoa.n_filhos == 3 and pessoa.salario <= 500.0]
        return mulheres
