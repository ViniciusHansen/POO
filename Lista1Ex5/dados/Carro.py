class Carro:
    def __init__(self):
        self.fabricante = ""
        self.modelo = ""
        self.cor = ""

    def __str__(self):
        return "Fabricante: {} - Modelo: {} - Cor: {}".format(self.fabricante,self.modelo,self.cor)