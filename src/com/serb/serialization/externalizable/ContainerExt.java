/*
 * ContainerExt
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

import java.io.*;
import java.util.*;

/**
 * ContainerExt
 *
 * This class represents abstract externalizable item container. Serialization
 * implementation should be done in subclasses
 *
 * @author Eugene Matyushkin
 * @version 1.0
 */
public abstract class ContainerExt implements Externalizable{

    protected List<ItemExt> items;

    public ContainerExt(){
        items = new LinkedList<ItemExt>();
    }

    public void addItem(ItemExt item){
        items.add(item);
    }


    public String toString() {
        return "Container "+getClass().getName()+": "+items.size()+" items";
    }

}
