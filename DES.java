
package des;
import javax.crypto.*;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
/**
 *
 * @author shaheer ali
 */
public class Des 
{

    /**
     * @param args the command line arguments
     */
     /**
     *
     * @param args
     * @throws javax.crypto.NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException 
    {
        try {
           
            KeyGenerator mykeygen = KeyGenerator.getInstance("DES");
            SecretKey deskey = mykeygen.generateKey();
            
            Cipher encrypt = Cipher.getInstance("DES");
            encrypt.init(Cipher.ENCRYPT_MODE,deskey);
            
            String message ;
            Scanner in = new Scanner(System.in);
            message = in.nextLine();
            System.out.println("enter message to encrypt message");

            byte[] mybytes = message.getBytes();
            
            byte[] myencryptedbyte =encrypt.doFinal(mybytes);
            System.out.print("encrypted  message is " + Arrays.toString(myencryptedbyte)+ "\n");
               
            Cipher decrypt = Cipher.getInstance("DES");
            
            decrypt.init(Cipher.DECRYPT_MODE,deskey);
            
            byte[] decyptedbyte = decrypt.doFinal(myencryptedbyte);
            String actual_msg = new String(decyptedbyte);
            
            System.out.print("actual message  "+ actual_msg+ "\n");
        }
        
        catch (InvalidKeyException ex) 
        {
            Logger.getLogger(Des.class.getName()).log(Level.SEVERE, null, ex);
        }
           
}
}