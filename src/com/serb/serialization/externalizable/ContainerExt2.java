/**
 * ContainerExt2
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
 * ContainerExt2
 *
 * This class represents externalizable items container with item-by-item
 * serialization implementation.
 *
 * @author Eugene Matyushkin
 * @version 1.0
 */
public class ContainerExt2 extends ContainerExt{

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(items.size());
        for(Externalizable ext : items)
            out.writeObject(ext);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int count = in.readInt();
        for(int i=0; i<count; i++){
            ItemExt ext = (ItemExt)in.readObject();
            items.add(ext);
        }
    }

}
