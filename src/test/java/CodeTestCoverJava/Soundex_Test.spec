
---

 Test Case 1:   
 Test Case Name:   testEmptyString   
 Test Description:   
When the input is an empty string, the output should also be an empty string.  
 Input:   ""   
 Expected Output:   "" 

---

 Test Case 2:   
 Test Case Name:   testSingleCharacter   
 Test Description:   
When the input is a single character, retain that character in uppercase and pad the result with zeros to make it four characters.  
 Input:   "J"   
 Expected Output:   "J000" 

---

 Test Case 3:   
 Test Case Name:   testStringWithSpace   
 Test Description:   
When the input string contains spaces, only the first character is retained, and the rest of the result is padded with zeros.  
 Input:   "D WW"   
 Expected Output:   "D000" 

---

 Test Case 4:   
 Test Case Name:   testStringWithVowelsOnly   
 Test Description:   
When the input string contains only vowels, retain the first vowel and pad the rest of the result with zeros.  
 Input:   "AEIOU"   
 Expected Output:   "A000" 

---

 Test Case 5:   
 Test Case Name:   testStringForSoundJ   
 Test Description:   
For a general string like  "Jenkins" , retain the first character and encode the rest according to the Soundex rules.  
 Input:   "Jenkins"   
 Expected Output:   "J525" 

---

 Test Case 6:   
 Test Case Name:   testStringForSoundH   
 Test Description:   
For a general string like  "Hamilton" , retain the first character and encode the rest according to the Soundex rules.  
 Input:   "Hamilton"   
 Expected Output:   "H543" 

---
