package ru.gb.mark.refactoring.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.gb.mark.refactoring.service.Loading;

@Data
@EqualsAndHashCode(callSuper = false)
public class Lorry extends Car implements Loading /* remove - implements Movable, Stoppable */ {

    private int capacity;

    @Override
    public void load(int weight) {
        capacity -= weight;
        System.out.format(
                "Load %s, Free capacity is %d Kg" + System.lineSeparator(),
                this.getName(),
                capacity
        );
    }
}
