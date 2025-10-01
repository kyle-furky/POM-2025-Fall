package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;


public class Challenge21CollectionsTest {


    // ✅ Utility Method FIRST or declared before usage (for clarity)
    private Set<String> findDuplicates(List<String> list) {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (String item : list) {
            if (!seen.add(item)) { // if add() returns false → duplicate found
                duplicates.add(item);
            }
        }
        return duplicates;
    }



    @Test
    public void testProductListValidation(){

        //step1 simulated product list from UI
        List<String> actualProducts=new ArrayList<>();
        actualProducts.add("backpack");
        actualProducts.add("bike light");
        actualProducts.add("bolt t-shirt");


        //step2 expected product list from requirement
        List<String> expectedProducts= Arrays.asList(
          "backpack",
          "bike light",
          "bolt t-shirt"
        );

        //step3 compare lists ignoring duplicates
        Set<String> actualSet=new HashSet<>(actualProducts);
        Set<String> expectedSet=new HashSet<>(expectedProducts);

        //assertion1 ensure all expected items exist
        Assert.assertEquals(actualSet,expectedProducts,
                "product list do not match!");

        //step4 detect duplicates
        Set<String> duplicates=findDuplicates(actualProducts);

        //assertion2 ensure no duplicates
        Assert.assertTrue(duplicates.isEmpty(),
                "There are duplicate products: "+duplicates);

        //step5 print summary
        System.out.println("+++ All expected products are present and nu duplicates found.");

    }


    // Utility Method: Find duplicates



    /*
    ✅ Quick Checklist:
    Make sure findDuplicates() is not inside the testProductListValidation() method.
    It must be declared at class level.

    findDuplicates() checks for any repeated elements — a common QA check.
    If any duplicates exist, the test fails and prints them in the console.
    Finally, print success if all validations pass ✅
     */

    // PRODUCT ISIMLERI AYNI OLSA BILENE HATA VERIYOR
    //Lists differ at element [0]: backpack != bolt t-shirt
    // KODDA DEGISIKLIK YAPMAK GEREKIYOR, TAM ISE YARAMIYOR BU KOD











}
