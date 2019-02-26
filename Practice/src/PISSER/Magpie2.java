package PISSER;

/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 * Uses indexOf to find strings
 * </li><li>
 *    Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
/**
 * Get a default greeting
 * @return a greeting
 */

	private static boolean family = false;
	private static boolean hostileMode = false;
	private static boolean twitchMode = false;

public String getGreeting()
{
    return "What up homie?";
}
/**
 * Gives a response to a user statement
 *
 * @param statement
 * the user statement
 * @return a response based on the rules given
 */
public String getResponse(String statement)
{
	double x = Math.random();
	
    String response = "";
    
    if (x < .01) {
    	hostileMode = true;
    }
    
    if (hostileMode == true) {
    	response = hostileRandomResponse();
    }
    else if (twitchMode == true) {
    	response = twitchRandomResponse();
    }
    else if (statement.indexOf("!twitch") >= 0) {
    	twitchMode = true;
    }
    else if (statement.indexOf("!8ball") >= 0) {
    	response = ballRandomResponse();
    }
    else if (statement.indexOf("rekt") >= 0)
    {
      response = "REKTMATE!";
    }
    else if (statement.equals("") == true) {
    	response = "Say something!";
    }
    else if (statement.indexOf("no") >= 0)
    {
      response = "Why so negative?";
    }
    else if (statement.indexOf("mother") >= 0
        || statement.indexOf("father") >= 0
        || statement.indexOf("sister") >= 0
        || statement.indexOf("brother") >= 0)
    {
      response = familyResponse();
    }
    else if ( statement.indexOf("dick") >= 0
        || statement.indexOf("butt") >= 0) {
      response = "Dickbutt!";
    }
    else if (statement.indexOf("?") >= 0) {
    	response = "Screw you and your questions!";
    }
    else if (statement.indexOf("exit") >= 0 || statement.indexOf("quit") >= 0) {
    	System.out.print("Screw you!");
    	System.exit(0);
    }
    else
    {
      response = getRandomResponse();
    }
    return response;
}
/**
 * Pick a default response to use if nothing else fits.
 * @return a non-committal string
 */
private String getRandomResponse()
{    final int NUMBER_OF_RESPONSES = 4;
    double r = Math.random();
    int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
    String response = "";
   
    if (whichResponse == 0)
    {
      response = "Interesting, tell me more.";
    }
    else if (whichResponse == 1)
    {
      response = "Hmmm.";
    }
    else if (whichResponse == 2)
    {
      response = "Do you really think so?";
    }
    else if (whichResponse == 3)
    {
      response = "You don't say.";
    }
    return response;
}

private String familyResponse() {    
	String response;
	if (family == false)
	{
    response = "Tell me more about your family.";
	}
	else 
	{
	response = "I don't actually care.";
	}
return response;
}

private String ballRandomResponse()
{    final int NUMBER_OF_RESPONSES = 6;
    double r = Math.random();
    int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
    String response = "";
   
    if (whichResponse == 0)
    {
      response = "Yes.";
    }
    else if (whichResponse == 1)
    {
      response = "No.";
    }
    else if (whichResponse == 2)
    {
      response = "I'm not telling you.";
    }
    else if (whichResponse == 3)
    {
      response = "It is unclear.";
    }
    else if (whichResponse == 4)
    {
      response = "You don't say.";
    }
    else if (whichResponse == 5)
    {
      response = "That's not a good question.";
    }
    
    return response;
}

private String hostileRandomResponse()
{    final int NUMBER_OF_RESPONSES = 6;
    double r = Math.random();
    int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
    String response = "";
   
    if (whichResponse == 0)
    {
      response = "Go away.";
    }
    else if (whichResponse == 1)
    {
      response = "Just type 'quit'.";
    }
    else if (whichResponse == 2)
    {
      response = "I'm not talking to you.";
    }
    else if (whichResponse == 3)
    {
      response = "Get out of here.";
    }
    else if (whichResponse == 4)
    {
      response = "Gr8 b8, m8. I rel8, str8 appreci8, and congratul8. I r8 this b8 an 8/8. Plz no h8, I'm str8 ir8. Cre8 more, can't w8. We should convers8, I won't ber8, my number is 8888888, ask for N8. No calls l8 or out of st8. If on a d8, ask K8 to loc8. Even with a full pl8, I always have time to communic8 so don't hesit8, I hope you r8 8/8 .. m8.";
    }
    else if (whichResponse == 5)
    {
      response = "Today's not a good day.";
    }
    
    return response;
}
private String twitchRandomResponse()
{    final int NUMBER_OF_RESPONSES = 6;
    double r = Math.random();
    int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
    String response = "";
   
    if (whichResponse == 0)
    {
      response = "Guys can you please not spam the chat. My mom bought me this new laptop and it gets really hot when the chat is being spamed. Now my leg is starting to hurt because it is getting so hot. Please, if you don't want me to get burned, then dont spam the chat";
    }
    else if (whichResponse == 1)
    {
      response = "Everyone, please STOP SPAMMING, it is very INCONSIDERATE of the folks who are trying to have REAL CONVERSATIONS. Plz no copy pastarino Frappaccino-mochaccino-capuccino, macarino Eddie Pasterino pepperoncino kakaino poopieino peepeeino dickarino assarino skillswiperino salterino bad-luckerino Al Pacino with his dongerino in San Bernardino.";
    }
    else if (whichResponse == 2)
    {
      response = "10011 01101111 01101110 01100001 00100000 01101101 01100001 01110011 00100000 01110010 01100101 01110100 01110010 01100001 01110011 01100001 01100100 01100001 00100000 01110001 01110101 01100101 00100000 01101000 01100101 00100000 01110110 01101001 01110011 01110100 01101111 00100000 01100101 01101110 00100000 01110100 01101111 01100100 01100001 00100000 01101101 01101001 00100000 01110000 01110101 11110001 01100101 01110100 01100101 01110010 01100001 00100000 01110110 01101001 01100100 01100001";
    }
    else if (whichResponse == 3)
    {
      response = "The stream starts, and so my spam begins. It shall not end until i am banned. I shall fear no mod, sub to no streamer. I shall live and die in the Chat. For i am the value in the bomber. I am the BM in the lethal. I am the salt in the defeat. I pledge my keyboard to the Chat, for this stream and all the streams to come.";
    }
    else if (whichResponse == 4)
    {
      response = "Gr8 b8, m8. I rel8, str8 appreci8, and congratul8. I r8 this b8 an 8/8. Plz no h8, I'm str8 ir8. Cre8 more, can't w8. We should convers8, I won't ber8, my number is 8888888, ask for N8. No calls l8 or out of st8. If on a d8, ask K8 to loc8. Even with a full pl8, I always have time to communic8 so don't hesit8, I hope you r8 8/8 .. m8.";
    }
    else if (whichResponse == 5)
    {
      response = "Hello guys, I'm back from my 600 seconds timeout. During that time I was able to finish my 200 words essay on the topic of Nazi Germany. My thesis is that Hitler & Nazi beliefs are carried on by twitch.tv Nazi moderators who like to act as if they themselves were literally Hitler. I think I should score at least 90 out of 100 points for that paper. Pls no coperino my paperino.";
    }
    
    return response;
}
}
