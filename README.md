# Parrot Refactoring Kata - Refatoração com Polimorfismo

## 🎯 Objetivo do Projeto

Este repositório é uma versão refatorada do kata "Parrot Refactoring Kata", que originalmente possuía código legado com uso intensivo de condicionais `switch` e má organização de responsabilidades. O objetivo foi:

- Tornar o código mais legível, coeso e orientado a objetos.
- Aplicar princípios de engenharia de software como **polimorfismo**, **remoção de duplicação**, **encapsulamento** e **responsabilidades únicas**.
- Garantir preservação do comportamento por meio de testes automatizados.

---

## 📦 Estrutura Original

A classe `Parrot` usava um `enum` para representar o tipo de papagaio e um método `getSpeed()` com `switch-case` para decidir o comportamento:

```java
public double getSpeed() {
    switch (type) {
        case EUROPEAN:
            return 12.0;
        case AFRICAN:
            return Math.max(0.0, 12.0 - 9.0 * numberOfCoconuts);
        case NORWEGIAN_BLUE:
            return isNailed ? 0.0 : Math.min(24.0, voltage * 12.0);
    }
}
```

---

## 🔨 Refatorações Realizadas

### ✅ Substituição do `switch-case` por Polimorfismo

Criamos subclasses específicas:
- `EuropeanParrot`
- `AfricanParrot`
- `NorwegianBlueParrot`

Cada subclasse possui seu próprio comportamento para `getSpeed()` e `getCry()`:

```java
public class AfricanParrot extends Parrot {
    private final int numberOfCoconuts;

    public AfricanParrot(int numberOfCoconuts) {
        this.numberOfCoconuts = numberOfCoconuts;
    }

    @Override
    public double getSpeed() {
        return Math.max(0.0, 12.0 - 9.0 * numberOfCoconuts);
    }
}
```

### ✅ Eliminação de Código Morto
- `ParrotTypeEnum` e construtores com múltiplos parâmetros foram eliminados.

### ✅ Criação de Testes Específicos com JUnit 5
- Nova suíte de testes: `PolymorphicParrotTest.java`.

### ✅ Implementação de Sons (`getCry()`)
- Comportamentos distintos para cada papagaio com base em suas características.

---

## ✅ Exemplos de Uso

```java
Parrot parrot1 = new EuropeanParrot();
Parrot parrot2 = new AfricanParrot(2);
Parrot parrot3 = new NorwegianBlueParrot(1.5, false);

System.out.println(parrot1.getSpeed()); // 12.0
System.out.println(parrot2.getSpeed()); // 0.0
System.out.println(parrot3.getSpeed()); // 18.0
```

---

## 🧪 Testes Automatizados

Todos os comportamentos foram testados com JUnit:

```bash
mvn clean test
```

Exemplos de teste:
```java
@Test
public void norwegianBlueNotNailedLowVoltage() {
    Parrot parrot = new NorwegianBlueParrot(1.5, false);
    assertEquals(18.0, parrot.getSpeed(), 0.01);
}
```

---

## 🧠 Justificativas Técnicas

- **Polimorfismo** substitui condicionais múltiplas com melhor extensibilidade.
- **Princípio Aberto/Fechado (OCP)**: novas espécies podem ser adicionadas sem modificar classes existentes.
- **Testabilidade** aumentada com cobertura por tipo.

---

## 📄 Autoria
Refatorado por Uendel Ives para fins didáticos e aplicação prática de boas práticas de engenharia de software.

Baseado no repositório original de Emily Bache: [Parrot Refactoring Kata](https://github.com/emilybache/Parrot-Refactoring-Kata)
