package com.example.lottoadvanced;

import java.util.Random;

public class LottoLogic implements ILottoNumbersLogic 
{
	private int maxNumber;
	private int minNumber;
	private int numberOfGuessedNumbers;
	private int [] generatedNumbers;
	private final Random rand = new Random();
	private static LottoLogic lotto = null;
	
	private LottoLogic()
	{
		minNumber = 1;
		maxNumber = 36;
		numberOfGuessedNumbers = 6;
	}
	
	static LottoLogic getLottoLogic()
	{
		if(lotto == null)
		{
			lotto = new LottoLogic();
		}
		
		return lotto;
	}

	@Override
	public void setMaxNumber(int max) 
	{
		maxNumber = max;
	}

	@Override
	public void setMinNumber(int min) 
	{
		minNumber = min;
	}

	@Override
	public int[] generateNumbers() 
	{
		generatedNumbers = new int[numberOfGuessedNumbers];
		for (int i = 0; i<numberOfGuessedNumbers; i++)
		{
			generatedNumbers[i] = rand.nextInt(maxNumber - minNumber + 1) + minNumber;
			while(checkEqual(generatedNumbers, i, generatedNumbers[i]))
			{
				generatedNumbers[i] = rand.nextInt(maxNumber - minNumber + 1) + minNumber;
			}
		}
		return generatedNumbers;
	}

	@Override
	public void setNumberOfGuessedNumbers(int number) 
	{
		if(number < maxNumber - minNumber)
		{
			numberOfGuessedNumbers = number;
		}
		else
		{
			numberOfGuessedNumbers = maxNumber - minNumber - 1;
		}
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public int getMinNumber() {
		return minNumber;
	}

	public int getNumberOfGuessedNumbers() {
		return numberOfGuessedNumbers;
	}

	public int[] getGeneratedNumbers() {
		return generatedNumbers;
	}

	@Override
	public boolean checkEqual(int[] numsArr, int index, int number) {
		boolean equals = false;
		for (int i = index - 1; i >= 0; i--)
		{
			if(number == numsArr[i])
			{
				equals = true;
				break;
			}
		}
		return equals;
	}

}
