package com.example.lottoadvanced;

public interface ILottoNumbersLogic {

public abstract void setMaxNumber(int max);
public abstract void setMinNumber(int min);
public abstract int[] generateNumbers();
public abstract void setNumberOfGuessedNumbers(int number);
public boolean checkEqual(int [] numsArr, int index, int number);

}
