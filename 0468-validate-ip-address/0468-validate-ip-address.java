class Solution {
    public boolean isValidIPv4(int[] arr) {
        if (arr.length != 4) {
            return false;
        }

        for (int num : arr) {
            if (num < 0 || num > 255) {
                return false;
            }
        }

        return true;
    }

    public boolean isValidIPv6(int[] arr) {
        if (arr.length != 8) {
            return false;
        }

        for (int num : arr) {
            if (num < 0 || num > 0xFFFF) {
                return false;
            }
        }

        return true;
    }

      public boolean isHexadecimalDigit(char c) {
        return (Character.isDigit(c) || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f'));
    }

public String validIPAddress(String queryIP) {
        if (queryIP.indexOf('.') != -1) {
            // Check for IPv4
            String[] parts = queryIP.split("\\.");
            if (parts.length != 4|| queryIP.endsWith(".")) {
                return "Neither";
            }
            int[] ipAddressArray = new int[parts.length];

            try {
                for (int i = 0; i < parts.length; i++) {
                    ipAddressArray[i] = Integer.parseInt(parts[i]);
                    if (ipAddressArray[i] < 0 || ipAddressArray[i] > 255 || (parts[i].length() > 1 && parts[i].charAt(0) == '0')) {
                        return "Neither";
                    }
                }

                return "IPv4";
            } catch (NumberFormatException e) {
                return "Neither";
            }
        } else if (queryIP.indexOf(':') != -1) {
            // Check for IPv6
            String[] parts = queryIP.split(":");
             if (parts.length != 8 || queryIP.endsWith(":")) {
                return "Neither";
            }
                

            for (String part : parts) {
                if (part.isEmpty() || part.length() > 4 || !part.matches("[0-9a-fA-F]+")) {
                    return "Neither";
                }
            }

            return "IPv6";
        }

        return "Neither";
    }

    






    




   
  






}