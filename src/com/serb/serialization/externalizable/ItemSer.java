/*
 * ItemSer
 *
 * Copyright (c) 2005 Eugene Matyushkin (E-mail: skipy@mail.ru)
 *
 * License agreement:
 *
 * 1. This code is published AS IS. Author is not responsible for any damage that can be
 *    caused by any application that uses this code.
 * 2. Author does not give a garantee, that this code is error free.
 * 3. This code can be used in NON-COMMERCIAL applications AS IS without any special
 *    permission from author.
 * 4. This code can be modified without any special permission from author IF AND ONLY IF
 *    this license agreement will remain unchanged.
 * 5. SPECIAL PERMISSION for this code usage in COMMERCIAL application SHOULD be obtained
 *    from author.
 */
package com.serb.serialization.externalizable;

import java.io.Serializable;

/**
 * ItemSer
 *
 * This class represents simple serializable item with quite arbitrary structure
 * identical to {@link ItemExt} class
 *
 * @author Eugene Matyushkin
 * @version 1.0
 */
public class ItemSer implements Serializable{
    
    private int fieldInt;
    private boolean fieldBoolean;
    private long fieldLong;
    private float fieldFloat;
    private double fieldDouble;
    private String fieldString;
    
    public ItemSer(int fieldInt, 
                   boolean fieldBoolean, 
                   long fieldLong, 
                   float fieldFloat,
                   double fieldDouble, 
                   String fieldString){
        this.fieldInt = fieldInt;
        this.fieldBoolean = fieldBoolean;
        this.fieldLong = fieldLong;
        this.fieldFloat = fieldFloat;
        this.fieldDouble = fieldDouble;
        this.fieldString = fieldString;
    }

    public int getFieldInt() {
        return fieldInt;
    }

    public boolean getFieldBoolean() {
        return fieldBoolean;
    }

    public long getFieldLong() {
        return fieldLong;
    }

    public float getFieldFloat() {
        return fieldFloat;
    }

    public double getFieldDouble() {
        return fieldDouble;
    }

    public String getFieldString() {
        return fieldString;
    }


}
