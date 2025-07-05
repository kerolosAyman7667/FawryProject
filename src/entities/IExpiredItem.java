package entities;

import java.time.LocalDate;

public interface IExpiredItem
{
	boolean isExpired();
	
	LocalDate getExpireDate();
}
