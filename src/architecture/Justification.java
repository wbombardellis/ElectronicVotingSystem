package architecture;

public class Justification
{
	private Member author;
	private String justification;
	
	public Justification(String justification, Member author)
	{
		this.author = author;
		this.justification = justification;
	}
	
	public Member getAuthor()
	{
		return this.author;
	}
	
	public String getJsutification()
	{
		return this.justification;
	}
}
