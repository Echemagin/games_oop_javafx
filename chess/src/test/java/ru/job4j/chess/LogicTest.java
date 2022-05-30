package ru.job4j.chess;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.*;

public class LogicTest {
    @Test (expected = ImpossibleMoveException.class)
    public void whenFigureMovesInvalid()
            throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.C2);
    }

    @Test (expected = OccupiedCellException.class)
    public void whenCellIsOccupied()
            throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.D2));
        logic.move(Cell.C1, Cell.D2);
    }

    @Test (expected = FigureNotFoundException.class)
    public void whenFigureIsNotExists()
            throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C2, Cell.C3);
    }
}