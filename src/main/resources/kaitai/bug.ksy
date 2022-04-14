meta:
  id: bug
  file-extension: na
  endian: le
seq:
  - id: body
    type: type_inner
# uncomment to fix bug
#  - id: body2
#    type: type_unused
types:
  type_reused:
    seq:
      - id: count
        type: s4
  type_inner:
    seq:
      - id: file_name
        type: type_reused
  type_unused:
    seq:
      - id: source_code_loc
        type: type_reused