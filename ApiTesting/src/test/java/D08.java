import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class D08 {
    @Test
    public void test()
    {
        JSONObject kisiBilgisi = new JSONObject();
        JSONObject adresBilgisi = new JSONObject();
        JSONObject cepTelefonu = new JSONObject();
        JSONObject phonenumbers = new JSONObject();
        JSONArray telBilgileri = new JSONArray();

        cepTelefonu.put("type","iPhone");
        cepTelefonu.put("type","0123-4567-8888");
        phonenumbers.put("type","home");
        phonenumbers.put("type","0123-4567-8910");
        telBilgileri.put(1,cepTelefonu);
        telBilgileri.put(0,phonenumbers);
        adresBilgisi.put("streetAddress","naist street");
        adresBilgisi.put("city","Nara");
        adresBilgisi.put("postalCode","630-0192");

        //
        kisiBilgisi.put("firstName","John");
        kisiBilgisi.put("lastname","doe");
        kisiBilgisi.put("age","26");
        kisiBilgisi.put("address",adresBilgisi);
        kisiBilgisi.put("telBilgileri",telBilgileri);

        System.out.println(kisiBilgisi);

        System.out.println(kisiBilgisi.get("firstName"));
        System.out.println(kisiBilgisi.get("lastname"));
        System.out.println(kisiBilgisi.get("age"));
        System.out.println(kisiBilgisi.getJSONObject("address").get("postalCode"));
        System.out.println(kisiBilgisi.getJSONArray("telBilgileri").getJSONObject(1).get("type"));


    }
}
