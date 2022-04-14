meta:
  id: jt
  file-extension: jt
seq:
  - id: version
    type: str
    size: 80
    encoding: ASCII
  - id: byte_order
    type: u1
  - id: body
    type: jt_body
types:
  jt_body:
    meta:
      endian:
        switch-on: _root.byte_order
        cases:
          0: le
          1: be
    seq:
      - id: header
        type: jt_header
    instances:
      toc_segment:
        pos: header.toc_offset
        type: toc_segment
    enums:
      variability:
        0: unknown
        1: constant
        2: uniform
        3: varying
      semantic_binding:
        0: unknown
        1: none
        2: position
        3: normal
        4: binormal
        5: blend_indices
        6: blend_weight
        7: tangent
        8: point_size
        10: tex_coord_0
        11: tex_coord_1
        12: tex_coord_2
        13: tex_coord_3
        14: tex_coord_4
        15: tex_coord_5
        16: tex_coord_6
        17: tex_coord_7
        20: fog_coordinate
        21: primary_color_output_input
        22: secondary_color
        23: primary_color_na_output
        24: depth_value
      direction:
        0: unknown
        1: input
        2: output
        3: both
      value_class:
        0: unknown
        1: immediate
        2: semantic
      param_type:
        0: unknown
        1: boolean
        2: integer
        3: float
        4: vec2i
        5: vec3i
        6: vec4i
        7: vec2f
        8: vec3f
        9: vec4f
        10: mat2x2f
        11: mat3x3f
        12: mat4x4f
        13: sampler1d
        14: sampler2d
        15: sampler3d
        16: sampler_rectmap
        17: sampler_cube_map
        18: sampler1d_shadow_map
        19: sampler2d_shadow_map
      shader_language:
        0: none
        2: glsl
      state_flags:
        0x01: accumulation_final
        0x02: accumulation_force
        0x04: accumulation_ignore
        0x08: attribute_persistable
      compression_level:
        0: lossless
        10: minimally_lossy
        50: moderate_lossy
        100: aggressive_lossy
        -1: unknown
      segment_type:
        1: logical_scene_graph
        2: jt_b_rep
        3: pmi_data
        4: meta_data
        6: shape
        7: shape_lod0
        8: shape_lod1
        9: shape_lod2
        10: shape_lod3
        11: shape_lod4
        12: shape_lod5
        13: shape_lod6
        14: shape_lod7
        15: shape_lod8
        16: shape_lod9
        17: xt_b_rep
        18: wireframe_representation
        20: ulp
        24: lwpa
      compression_algo:
        1: no_compression
        2: zlib_compression
      element_type:
        0: unknown
        1: end_of_elements
        2: base_node_element
        3: partition_node_element
        4: group_node_element
        5: instance_node_element
        6: part_node_element
        7: meta_data_node_element
        8: lod_node_element
        9: range_lod_node_element
        10: switch_node_element
        11: base_shape_node_element
        12: vertex_shape_node_element
        13: tri_strip_set_shape_node_element
        14: polyline_set_shape_node_element
        15: point_set_shape_node_element
        16: polygon_set_shape_node_element
        17: null_shape_node_element
        18: primitive_set_shape_node_element
    types:
      guid:
        seq:
          - id: a
            type: u4
          - id: b
            type: u2
          - id: c
            type: u2
          - id: d
            type: u1
          - id: e
            type: u1
          - id: f
            type: u1
          - id: g
            type: u1
          - id: h
            type: u1
          - id: i
            type: u1
          - id: j
            type: u1
          - id: k
            type: u1
      mb_string:
        seq:
          - id: count
            type: s4
          - id: str
            type: u2
            repeat: expr
            repeat-expr: count
      vec_f32:
        seq:
          - id: count
            type: s4
          - id: data
            type: f4
            repeat: expr
            repeat-expr: count
      vec_f64:
        seq:
          - id: count
            type: s4
          - id: data
            type: f8
            repeat: expr
            repeat-expr: count
      vec_i32:
        seq:
          - id: count
            type: s4
          - id: data
            type: s4
            repeat: expr
            repeat-expr: count
      vec_u32:
        seq:
          - id: count
            type: s4
          - id: data
            type: u4
            repeat: expr
            repeat-expr: count
      dir_f32:
        seq:
          - id: data
            type: f4
            repeat: expr
            repeat-expr: 3
      coord_f32:
        seq:
          - id: data
            type: f4
            repeat: expr
            repeat-expr: 3
      coord_f64:
        seq:
          - id: data
            type: f8
            repeat: expr
            repeat-expr: 3
      bbox_f32:
        seq:
          - id: min_corner
            type: coord_f32
          - id: max_corner
            type: coord_f32
      jt_header:
        seq:
          - id: reserved_field
            type: s4
          - id: toc_offset
            type: s4
          - id: lsg_segment_id
            type: guid
      toc_segment:
        seq:
          - id: entry_count
            type: s4
          - id: entries
            type: toc_entry
            repeat: expr
            repeat-expr: entry_count
      toc_entry:
        types:
          segment_attr:
            seq:
              - id: reserved
                type: b24
              - id: attribute
                type: b8
                enum: segment_type
        seq:
          - id: segment_id
            type: guid
          - id: segment_offset
            type: s4
          - id: segment_length
            type: s4
          - id: segment_attrs
            type: segment_attr
        instances:
          data:
            pos: segment_offset
            size: segment_length
            type: data_segment
      data_segment:
        seq:
          - id: header
            type: segment_header
          - id: body
            type:
              switch-on: header.segment_type
              cases:
                segment_type::logical_scene_graph: lsg_segment
        types:
          segment_header:
            seq:
              - id: segment_id
                type: guid
              - id: segment_type
                type: s4
                enum: segment_type
              - id: segment_length
                type: s4
          zlib_header:
            seq:
              - id: compression_flag
                type: s4
              - id: compressed_data_len
                type: s4
              - id: compression_algo
                type: u1
                enum: compression_algo
          logical_element_header:
            seq:
              - id: garbage
                type: mb_string
              - id: element_length
                type: s4
              - id: type_id
                type: guid
              - id: object_base_type
                type: u1
              - id: object_id
                type: s4
            instances:
              element_type:
                # python to gen: expr = lambda a,b : pyperclip.copy(" and ".join(f"type_id.{i}=={hex(j)}" for i,j in zip("abcdefghijk",a)) + f" ? element_type::{b}")
                value: >
                  type_id.a==0xffffffff and type_id.b==0xffff and type_id.c==0xffff and type_id.d==0xff and type_id.e==0xff and type_id.f==0xff and type_id.g==0xff and type_id.h==0xff and type_id.i==0xff and type_id.j==0xff and type_id.k==0xff ? element_type::end_of_elements
                  : type_id.a==0x10dd1035 and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x00 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::base_node_element
                  : type_id.a==0x10dd103e and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x0 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::partition_node_element
                  : type_id.a==0x10dd101b and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x0 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::group_node_element
                  : type_id.a==0x10dd102a and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x0 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::instance_node_element
                  : type_id.a==0xce357244 and type_id.b==0x38fb and type_id.c==0x11d1 and type_id.d==0xa5 and type_id.e==0x6 and type_id.f==0x0 and type_id.g==0x60 and type_id.h==0x97 and type_id.i==0xbd and type_id.j==0xc6 and type_id.k==0xe1 ? element_type::part_node_element
                  : type_id.a==0xce357245 and type_id.b==0x38fb and type_id.c==0x11d1 and type_id.d==0xa5 and type_id.e==0x6 and type_id.f==0x0 and type_id.g==0x60 and type_id.h==0x97 and type_id.i==0xbd and type_id.j==0xc6 and type_id.k==0xe1 ? element_type::meta_data_node_element
                  : type_id.a==0x10dd102c and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x0 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::lod_node_element
                  : type_id.a==0x10dd104c and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x0 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::range_lod_node_element
                  : type_id.a==0x10dd10f3 and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x0 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::switch_node_element
                  : type_id.a==0x10dd1059 and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x0 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::base_shape_node_element
                  : type_id.a==0x10dd107f and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x0 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::vertex_shape_node_element
                  : type_id.a==0x10dd1077 and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x0 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::tri_strip_set_shape_node_element
                  : type_id.a==0x10dd1046 and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x0 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::polyline_set_shape_node_element
                  : type_id.a==0x98134716 and type_id.b==0x10 and type_id.c==0x818 and type_id.d==0x19 and type_id.e==0x98 and type_id.f==0x8 and type_id.g==0x0 and type_id.h==0x9 and type_id.i==0x83 and type_id.j==0x5d and type_id.k==0x5a ? element_type::point_set_shape_node_element
                  : type_id.a==0x10dd1048 and type_id.b==0x2ac8 and type_id.c==0x11d1 and type_id.d==0x9b and type_id.e==0x6b and type_id.f==0x0 and type_id.g==0x80 and type_id.h==0xc7 and type_id.i==0xbb and type_id.j==0x59 and type_id.k==0x97 ? element_type::polygon_set_shape_node_element
                  : type_id.a==0xd239e7b6 and type_id.b==0xdd77 and type_id.c==0x4289 and type_id.d==0xa0 and type_id.e==0x7d and type_id.f==0xb0 and type_id.g==0xee and type_id.h==0x79 and type_id.i==0xf7 and type_id.j==0x94 and type_id.k==0x94 ? element_type::null_shape_node_element
                  : type_id.a==0xe40373c1 and type_id.b==0x1ad9 and type_id.c==0x11d3 and type_id.d==0x9d and type_id.e==0xaf and type_id.f==0x0 and type_id.g==0xa0 and type_id.h==0xc9 and type_id.i==0xc7 and type_id.j==0xdd and type_id.k==0xc2 ? element_type::primitive_set_shape_node_element
                  : element_type::unknown
          lsg_segment:
            seq:
              - id: zlib_header
                type: zlib_header
              - id: body
                type: lsg_segment_body
                size: zlib_header.compressed_data_len - 1
                process: name.kh4n.jtloader.zlib_inflate(zlib_header.compression_flag)
            types:
              lsg_segment_body:
                seq:
                  - id: graph_elements
                    type: lsg_graph_element
                    repeat: until
                    repeat-until: _.header.element_type == element_type::end_of_elements
              lsg_graph_element:
                seq:
                  - id: header
                    type: logical_element_header
                  - id: data
                    size: 'header.element_type==element_type::end_of_elements ? 0 : header.element_length - (16 + 1 + 4)'
                    type:
                      switch-on: header.element_type
                      cases:
                        element_type::end_of_elements: end_of_elements_data
                        element_type::base_node_element: base_node_data
                        element_type::group_node_element: group_node_data
                        element_type::partition_node_element: partition_node_data
                        element_type::instance_node_element: instance_node_data
                        element_type::part_node_element: part_node_data
                        element_type::meta_data_node_element: meta_data_node_data
                        element_type::lod_node_element: lod_node_data
                        element_type::range_lod_node_element: range_lod_node_data
                        element_type::switch_node_element: switch_node_data
                        element_type::base_shape_node_element: base_shape_data
                        element_type::vertex_shape_node_element: vertex_shape_data
                        element_type::tri_strip_set_shape_node_element: vertex_shape_data
                        element_type::polyline_set_shape_node_element: polyline_set_shape_node_data
                        element_type::point_set_shape_node_element: point_set_shape_node_data
                        element_type::polygon_set_shape_node_element: vertex_shape_data
                        element_type::null_shape_node_element: null_shape_node_data
                        element_type::primitive_set_shape_node_element: primitive_set_shape_node_data
              vertex_count_range:
                seq:
                  - id: min_count
                    type: s4
                  - id: max_count
                    type: s4
              node_count_range:
                seq:
                  - id: min_count
                    type: s4
                  - id: max_count
                    type: s4
              polygon_count_range:
                seq:
                  - id: min_count
                    type: s4
                  - id: max_count
                    type: s4
              quantization_params:
                seq:
                  - id: bits_per_vertex
                    type: u1
                  - id: normal_bits_factor
                    type: u1
                  - id: bits_per_texture_coord
                    type: u1
                  - id: bits_per_color
                    type: u1
              primitive_set_quantization_params:
                seq:
                  - id: bits_per_vertex
                    type: u1
                  - id: bits_per_color
                    type: u1
              shader_param:
                seq:
                  - id: param_name
                    type: mb_string
                  - id: param_type
                    type: u4
                    enum: param_type
                  - id: value_class
                    type: u4
                    enum: value_class
                  - id: direction
                    type: u4
                    enum: direction
                  - id: semantic_binding
                    type: u4
                    enum: semantic_binding
                  - id: variability
                    type: u4
                    enum: variability
                  - id: reserved_field
                    type: u4
                  - id: values
                    type: u4
                    repeat: expr
                    repeat-expr: 16
              meta_data_node_data:
                seq:
                  - id: group
                    type: group_node_data
                  - id: version_number
                    type: s2
              end_of_elements_data: {}
              base_node_data:
                seq:
                  - id: version_number
                    type: s2
                  - id: node_flags
                    type: u4
                  - id: attribute_count
                    type: s4
                  - id: attribute_object_id
                    type: s4
                    repeat: expr
                    repeat-expr: attribute_count
              group_node_data:
                seq:
                  - id: base
                    type: base_node_data
                  - id: version_number
                    type: s2
                  - id: child_count
                    type: s4
                  - id: child_node_object_id
                    type: s4
                    repeat: expr
                    repeat-expr: child_count
              partition_node_data:
                seq:
                  - id: group
                    type: group_node_data
                  - id: partition_flags
                    type: s4
                  - id: file_name
                    type: mb_string
                  - id: reserved_field
                    type: bbox_f32
                    if: partition_flags & 0x00000001 != 0
                  - id: transformed_bbox
                    type: bbox_f32
                    if: partition_flags & 0x00000001 == 0
                  - id: area
                    type: f4
                  - id: vertex_count_range
                    type: vertex_count_range
                  - id: node_count_range
                    type: node_count_range
                  - id: polygon_count_range
                    type: polygon_count_range
                  - id: untransformed_bbox
                    type: bbox_f32
                    if: partition_flags & 0x00000001 != 0
              instance_node_data:
                seq:
                  - id: base
                    type: base_node_data
                  - id: version_number
                    type: s2
                  - id: child_node_object_id
                    type: s4
              part_node_data:
                seq:
                  - id: meta_data
                    type: meta_data_node_data
                  - id: version_number
                    type: s2
                  - id: reserved_field
                    type: s4
              lod_node_data:
                seq:
                  - id: group
                    type: group_node_data
                  - id: version_number
                    type: s2
                  - id: reserved_field
                    type: vec_f32
                  - id: reserved_field2
                    type: s4
              range_lod_node_data:
                seq:
                  - id: lod
                    type: lod_node_data
                  - id: version_number
                    type: s2
                  - id: range_limits
                    type: vec_f32
                  - id: center
                    type: coord_f32
              switch_node_data:
                seq:
                  - id: group
                    type: group_node_data
                  - id: version_number
                    type: s2
                  - id: selected_child
                    type: s4
              base_shape_data:
                instances:
                  compression_level:
                    value: |
                      compression_level_raw == 0.0 ? compression_level::lossless
                      : compression_level_raw == 0.1 ? compression_level::minimally_lossy
                      : compression_level_raw == 0.5 ? compression_level::moderate_lossy
                      : compression_level_raw == 1.0 ? compression_level::aggressive_lossy
                      : compression_level::unknown
                seq:
                  - id: base
                    type: base_node_data
                  - id: version_number
                    type: s2
                  - id: reserved_field
                    type: bbox_f32
                  - id: untransformed_bbox
                    type: bbox_f32
                  - id: area
                    type: f4
                  - id: vertex_count_range
                    type: vertex_count_range
                  - id: node_count_range
                    type: node_count_range
                  - id: polygon_count_range
                    type: polygon_count_range
                  - id: size
                    type: s4
                  - id: compression_level_raw
                    type: f4
              vertex_shape_data:
                seq:
                  - id: base
                    type: base_shape_data
                  - id: version_number
                    type: s2
                  - id: vertex_binding
                    type: u8
                  - id: quantization_params
                    type: quantization_params
                  - id: vertex_binding2
                    type: u8
                    if: version_number != 1
              polyline_set_shape_node_data:
                seq:
                  - id: vertex_shape_data
                    type: vertex_shape_data
                  - id: version_number
                    type: s2
                  - id: area_factor
                    type: f4
                  - id: vertex_bindings
                    type: u8
                    if: version_number != 1
              point_set_shape_node_data:
                seq:
                  - id: vertex_shape_data
                    type: vertex_shape_data
                  - id: version_number
                    type: s2
                  - id: area_factor
                    type: f4
                  - id: vertex_bindings
                    type: u8
                    if: version_number != 1
              null_shape_node_data:
                seq:
                  - id: base
                    type: base_shape_data
                  - id: version_number
                    type: s2
              primitive_set_shape_node_data:
                seq:
                  - id: base
                    type: base_shape_data
                  - id: version_number
                    type: s2
                  - id: texture_coord_binding
                    type: s4
                  - id: color_binding
                    type: s4
                  - id: texture_coord_gen_type
                    type: s4
                  - id: version_number_format
                    type: s2
                  - id: primitive_set_quantization_params
                    type: primitive_set_quantization_params
              base_attribute_data:
                seq:
                  - id: version_number
                    type: s2
                  - id: state_flags
                    type: u1
                    enum: state_flags
                  - id: field_inhibit_flags
                    type: u4
              base_shader_data:
                seq:
                  - id: version_number
                    type: s2
                  - id: shader_language
                    type: s4
                    enum: shader_language
                  - id: inline_source_flag
                    type: u4
                  - id: source_code_loc
                    type: mb_string
                    if: inline_source_flag != 1
                  - id: source_code
                    type: mb_string
                    if: inline_source_flag == 1
                  - id: shader_param_count
                    type: s4
                  - id: shader_params
                    type: shader_param
                    repeat: expr
                    repeat-expr: shader_param_count



#                    continue with adding more lsg elements