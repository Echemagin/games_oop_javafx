package ru.job4j.chess.figures.black;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

public class BishopBlackTest {
    @Test
    public void whenBishopInitialized() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        int[] position = {
                bishop.position().getX(),
                bishop.position().getY()
        };
        int[] res = {0, 7};
        assertThat(position, is(res));
    }

    @Test
    public void whenBishopIsCopied() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        Figure resultBishop = bishop.copy(Cell.A4);
        int[] position = {
                resultBishop.position().getX(),
                resultBishop.position().getY()
        };
        int[] res = {0, 4};
        assertThat(position, is(res));
    }

    @Test
    public void whenBishopMoves() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] steps = bishop.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(steps, is(expected));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenBishopDestIsNotDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        bishop.way(Cell.G4);
    }
}
