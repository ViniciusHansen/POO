class Ponto2d:
    def __init__(self,x,y) -> None:
        self.x = int(x)
        self.y = int(y)
    def __str__(self) -> str:
        return "({},{})".format(self.x,self.y)

class Reta:
    def __init__(self,a,b) -> None:
        self.a = int(a)
        self.b = int(b)

    def intercepta(self, reta) -> bool:
        return not (self.a == reta.a and self.b != reta.b)

    def estaNaReta(self, ponto) -> bool:
        return ponto.y == self.a * ponto.x + self.b
    
    def __str__(self) -> str:
        if self.b < 0:
            return "y = {}x - {}".format(self.a,abs(self.b))
        return "y = {}x + {}".format(self.a,self.b)


class EspacoGeometrico:
    def __init__(self) -> None:
        self.retas = []
        self.pontos = []

    def addReta(self, reta: Reta) -> None:
        for r in self.retas:
            if reta.intercepta(r):
                raise ObjetoSobrepostoException(
                    "A reta {} intercepta a reta {} já existente".format(reta,r))
        else:
            self.retas.append(reta)

    def addPonto(self, ponto: Ponto2d) -> None:
        for r in self.retas:
            if r.estaNaReta(ponto):
                raise ObjetoSobrepostoException(
                    "O ponto {} pertence a reta {} já adicionada".format(ponto, r))
        else:
            self.pontos.append(ponto)


class ObjetoSobrepostoException(Exception):
    def __init__(self, msg) -> None:
        super().__init__(msg)
        self.msg = msg

    def __str__(self) -> str:
        return self.msg


def main():
    red = Reta(1,2)
    green = Reta(1,1)
    blue = Reta(2,-2)

    a = Ponto2d(3,4)
    b = Ponto2d(2,3)
    c = Ponto2d(4,6)
    d = Ponto2d(3,2)

    try:
        space = EspacoGeometrico()
        space.addReta(red)
        space.addReta(green)
        #space.addReta(blue)
        space.addPonto(a)
        space.addPonto(b)
        space.addPonto(c)
        space.addPonto(d)
    except ObjetoSobrepostoException as e:
        print(e)


if __name__ == '__main__':
    main()