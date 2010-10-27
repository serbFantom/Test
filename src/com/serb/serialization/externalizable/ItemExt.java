/*
 * ItemExt
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

import java.io.Externalizable;
import java.io.ObjectOutput;
import java.io.IOException;
import java.io.ObjectInput;

/**
 * ItemExt
 *
 * This class represents simple serializable item with quite arbitrary structure
 * identical to {@link ItemSer} class
 *
 * @author Eugene Matyushkin
 * @version 1.0
 */
public class ItemExt implements Externalizable{

    private int fieldInt;
    private boolean fieldBoolean;
    private long fieldLong;
    private float fieldFloat;
    private double fieldDouble;
    private String fieldString;

    public ItemExt(){
        this(0,true,0,0,0,"");
    }

    public ItemExt(int fieldInt,
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


    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(fieldInt);
        out.writeBoolean(fieldBoolean);
        out.writeLong(fieldLong);
        out.writeFloat(fieldFloat);
        out.writeDouble(fieldDouble);
        out.writeUTF(fieldString);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        fieldInt = in.readInt();
        fieldBoolean = in.readBoolean();
        fieldLong = in.readLong();
        fieldFloat = in.readFloat();
        fieldDouble = in.readDouble();
        fieldString = in.readUTF();
    }

}
