class Cliente:
    def __init__(self):
        self.nome = ""
        self.cpf = ""
        self.endereco = ""

    def __str__(self):
        return "Nome: {} - CPF: {} - Endereço: {}".format(self.nome,self.cpf,self.endereco)