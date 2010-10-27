/*
 * ContainerSer
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

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * ContainerExt
 *
 * This class represents serializable item container.
 *
 * @author Eugene Matyushkin
 * @version 1.0
 */
public class ContainerSer implements Serializable{

    private List<ItemSer> items;

    public ContainerSer(){
        items = new ArrayList<ItemSer>();
    }

    public void addItem(ItemSer item){
        items.add(item);
    }

    public String toString() {
        return "Items: "+items.size();
    }

}
